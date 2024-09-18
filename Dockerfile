FROM node:16-alpine AS frontend-build

# Sätt upp arbetskatalog för frontend
WORKDIR /app/frontend

# Kopiera package.json och installera beroenden
COPY frontend/package*.json ./
RUN npm install

# Kopiera frontend-koden och bygg applikationen
COPY frontend/ ./
RUN npm run build

# Bygg backend (Spring Boot med Gradle)
FROM gradle:7.5.1-jdk17 AS backend-build

# Sätt upp arbetskatalog för backend
WORKDIR /app/backend

# Kopiera Gradle wrapper och andra viktiga filer för att kunna bygga
COPY gradlew gradlew.bat build.gradle settings.gradle ./
COPY gradle gradle

# Kopiera backend-källkoden
COPY src ./src

# Bygg backend-applikationen
RUN ./gradlew bootJar

# Steg 3: Skapa produktionsimage
FROM openjdk:17-jdk-slim

# Skapa arbetskatalog i den slutgiltiga imagen
WORKDIR /app

# Kopiera backend-jar från byggsteget
COPY --from=backend-build /app/backend/build/libs/*.jar /app/backend.jar

# Kopiera byggda frontend-filer till backendens static-mapp (eller var de ska läggas)
COPY --from=frontend-build /app/frontend/dist/ /app/public/

# Exponera porten Spring Boot kör på
EXPOSE 8080

# Starta applikationen
ENTRYPOINT ["java", "-jar", "/app/backend.jar"]
