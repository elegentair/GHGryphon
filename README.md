# GHGryphon
A web application allowing L&amp;N students and staff to view, choose, and manage genius hour clubs.

## Setup
### Prerequisites:
- Java 27
### Frameworks (managed by Gradle):  
  - Javalin - Web Framework  
  - jOOQ - Database
  - Jackson Databind - Converts between Java objects & JSON
  - SLF4J Simple - Javalin logger
  - JUnit Jupiter - Testing framework

_Version information and other specifics are available in the Gradle build file:_ ```backend/app/build.gradle```

**Architecture flowchart (WIP):**
<p align="center">
  <img src="assets/flowchart.png" alt="Microsoft Visio flowchart summarizing the backend's architecture" width="75%" style="margin-left: auto; margin-right: auto">
</p>

Recommended: Install Temurin Java 27.0.0.0+35 with sdkman:
```sdk install java 27.0.0.0+35-tem```

Install Gradle: ```sdk install gradle```

Run backend: Ensure you are in the backend directory and run ```./gradew run```