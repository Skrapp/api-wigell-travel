# API Wigell Travel

Gruppuppgift under utbildningen Systemutveckling Java till kursen Backend. Uppgiften gick ut på att skapa en mikrotjänst som 
ska arbeta tillsammans med fler mikrotjänster från gruppen. Denna mikrotjänst simulerar en resetjänst. Den hanterar 
Destinationer, kunder och bokningar.

Huvudsyftet med uppgiften är att träna på:
- **REST API** Arbeta och förstå hur man skapar ett REST API
- **Mikrotjänster** Skapa autonoma tjänster som kan byggas samman till ett större system. Koppla samman med Dashboard 
och Gateway
- **Keycloak** Använda Keycloak för att auktorisera användare genom OAuth 2
- **Loggning** Logga information om vad som sker i applikationen

## ✅ Funktionalitet
Client gör anrop till localhost:8581 för att hämta, läsa, skapa, uppdatera och ta bort kunder, destinationer och 
bokningar. Anropen kräver att man har en token som USER eller ADMIN, vilket hämtas från Keycloak

## ⭐ Kom igång
Använder MySQL lokalt mot localhost:3306 

Tokens för användare hämtas från https://grupp-d.eduflexlms.se/

Om du sätter upp egna containers, se till att ändra i application.

Anrop kan man göra via Postman

Du kan hitta de andra mikrotjänsterna från gupparbetet här:
- Gateway: https://github.com/Skrapp/api-gateway-together
- Dashboard och Wigell Sushi: https://github.com/alexwest1981/Grupparbetet
- Wigell Cinema: https://github.com/kirrikirri123/wigell-portal-cinema
- Wigell Mc: https://github.com/LinusEdstrom/WigellMcRental
- Wigell Padel: https://github.com/LangeDex/Padel
- Currency Converter: https://github.com/kirrikirri123/currency-converter

## ✍️ Författare

Uppgift skapad för utbildningssyfte av Sara Nilsson.

LinkedIn: https://www.linkedin.com/in/sara-nilsson-774402220/

Github: https://github.com/Skrapp
