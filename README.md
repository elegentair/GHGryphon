# GHGryphon
A web application allowing L&amp;N students and staff to view, choose, and manage genius hour clubs.

## Backend Setup
### Prerequisites:
- Java 25 <span style="font-size: smaller;">(required for LTS; we use 25.0.5.1+2-tem)</span>
- Gradle 9.8.2
### Frameworks (Managed by Gradle):
- Javalin - Web framework  
- H2 - Database (currently local)
- Ebean - Implements SQL
- Jackson Databind - Converts between Java objects & JSON
- SLF4J Simple - Javalin logger
- JUnit Jupiter - Testing framework

_Version information and other specifics are available in the Gradle build file:_ ```backend/app/build.gradle```

#### Architecture Flowchart (WIP):
<p align="center">
  <img src="assets/flowchart.png" alt="Microsoft Visio flowchart summarizing the backend's architecture" width="75%" style="margin-left: auto; margin-right: auto">
</p>

### Functionality:
- Local H2 SQL database (users, clubs)
  - Currently functional; tested through `AppTest.java`
  - Intention: Implement PostgreSQL (remote database)
  - Intention: Add other necessary GH records & relationally link
- GET, POST, PUT, DELETE methods
  - GET method can retrieve one entry <span style="font-size: smaller;">(only ID-based for now)</span> or all of them
  - Generic HTTP methods (defined in `HttpHandler.java`) are applied to data in `App.java`
  - Possibility: Add PATCH method for transfer efficiency

### Instructions:
**Recommended:** Install Temurin Java 25.0.5.1+2-tem with sdkman:
```sdk install java 25.0.5.1+2-tem``` <span style="font-size: smaller;">(other Java 25 builds with LTS should work as well)</span>

Install Gradle <span style="font-size: smaller;">(automatically handles dependencies)</span>: ```sdk install gradle```

Configure Supabase secrets: Run ```cp secrets-template.sh secrets.sh``` while in the backend directory, and update ```secrets.sh``` to have Supabase credentials.
  - Running these commands in the terminal will be necessary before executing the app with the remote Supabase (this is not set up yet)

Run backend (local/legacy): Ensure you are in the backend directory and run ```./gradlew run```