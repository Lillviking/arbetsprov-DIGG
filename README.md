#Arbetsprov DIGG

Det här är en minimalistisk webbapplikation för att lägga till kunder och få en översikt av dem.
**localhost:5173**: Lista över kunder
**localhost:5173**: Lägg till kund

## 1. Krav
- Java: 22
- NodeJS och npm (för att köra frontend)

## 2. Frontend
- Navigera till frontend-katalogen
- Kör **npm install** för att installera alla beroenden.
- Kör **npm run dev** för att starta frontend-servern.
- Frontend är tillgängligt på http://localhost:5173.

## 3. Backend
- Navigera till katalogen där build.gradle ligger
- Kör **./gradlew build** för att bygga backend och ladda ner beroenden.
- Kör **./gradlew bootRun** för att starta Spring Boot-backend.
- Backend är tillgängligt på http://localhost:8080.

## 4. Databas
- Applikationen lagrar datat i minnet.

## 5. Val av tekniker

### 5.1 Teknikval (Backend: Spring Boot, Frontend: Vue3)
- Backend: Spring Boot har ett väletablerat ekosystem och har funnits länge på marknaden. 
- Frontend: Vue3 var inte valbart. Är annars ett väldigt praktiskt ramverk med Single File Component (SFC) som underlättar utvecklingen. 

### 5.2 Struktur och designval
- Arkitektur: Valde att inte använda mig utav en databas eftersom uppgiften specifikt anger att datan kan lagras internt i tjänsten. Detta minskar komplexiteten och tiden som skulle gått åt att konfigurera en databas och dess anslutningar. 

### 5.3 Felhantering och loggning
