<style>
  .smDescript {
    font-size: smaller;
  }
</style>

# GHGryphon
A web application allowing L&amp;N students and staff to view, choose, and manage genius hour clubs.

## Setup
### Prerequisites:
- Java 27
- Gradle 9.8.2
### Frameworks (managed by Gradle):
- Javalin - Web framework  
- Ebean - Implements SQL
- Jackson Databind - Converts between Java objects & JSON
- SLF4J Simple - Javalin logger
- JUnit Jupiter - Testing framework

_Version information and other specifics are available in the Gradle build file:_ ```backend/app/build.gradle```

#### Architecture flowchart (WIP):
<p align="center">
  <img src="assets/flowchart.png" alt="Microsoft Visio flowchart summarizing the backend's architecture" width="75%" style="margin-left: auto; margin-right: auto">
</p>

### Instructions:
**Recommended:** Install Temurin Java 27.0.0.0+35 with sdkman:
```sdk install java 27.0.0.0+35-tem``` <span class="smDescript">(other Java 27 builds should work as well)</span>

Install Gradle <span class="smDescript">(automatically handles dependencies)</span>: ```sdk install gradle```

Run backend: Ensure you are in the backend directory and run ```./gradew run```