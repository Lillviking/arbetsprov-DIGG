# Arbetsprov DIGG

Det här är en minimalistisk webbapplikation för att lägga till kunder och få en översikt av dem.

- **http://localhost:8080**: Lista över kunder 
- **http://localhost:8080/addCustomer**: Lägg till kund
(servas av Spring Boot)

## 1. Krav
- **Docker** (för att bygga och köra applikationen i en container)
- **Node.js och npm** (endast för utvecklingsmiljö utan Docker)
- Ingen separat installation av Java behövs om du använder Docker.

## 2. Köra applikationen med Docker

### 2.1 Bygga Docker-imagen
För att bygga Docker-imagen, kör följande kommando från projektets rotmapp (där Dockerfile finns):

```bash
docker build -t arbetsprov-digg .
docker run -p 8080:8080 arbetsprov-digg
```
## 3. Utvecklingsmiljö (utan Docker)

### 3.1 Frontend
- Navigera till frontend-katalogen.
- Kör npm install för att installera alla beroenden.
- Kör npm run dev för att starta frontend-servern för utveckling.
- Frontend är tillgängligt på http://localhost:5173.

### 3.2 Backend
- Navigera till katalogen där build.gradle ligger (backend-katalogen).
- Kör ./gradlew build för att bygga backend och ladda ner beroenden.
- Kör ./gradlew bootRun för att starta Spring Boot-backend för utveckling.
- Backend är tillgängligt på http://localhost:8080.

## 4. Databas
- Applikationen lagrar data i minnet, vilket innebär att all data försvinner när applikationen stoppas eller startas om.

## 5. Val av tekniker

### 5.1 Teknikval (Backend: Spring Boot, Frontend: Vue3)
- **Backend**: Spring Boot valdes för dess robusthet och väletablerade ekosystem. 
- **Frontend**: Vue3 användes för sin enkelhet och flexibilitet. Vue.js tillhandahåller Single File Components (SFC) som underlättar utvecklingen genom att samla HTML, JavaScript och CSS i en fil.

### 5.2 Struktur och designval
- **Arkitektur**: En databas användes inte, eftersom uppgiften specifikt anger att data kan lagras internt i tjänsten. Detta minskar komplexiteten och gör applikationen lättare att underhålla.

### 5.3 Felhantering och loggning
- **Felhantering**: Applikationen hanterar fel genom att validera inkommande kunddata och kasta undantag om data är ogiltig. Dessa undantag fångas upp och loggas, och felmeddelanden returneras till klienten. Vidare kan en global felhanterare implementeras i framtiden för att centralisera hanteringen av fel i applikationen.
- **Loggning**: Applikationen använder SLF4J och Logback för loggning. Fel loggas på `error`-nivå när något går fel, och framgångsrika operationer loggas på `info`-nivå.

## Test
För att köra testerna i backend-projektet, kör följande kommando från katalogen där `build.gradle` finns:
```bash
./gradlew test
```
