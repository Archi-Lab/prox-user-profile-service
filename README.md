# Prox User-Profile-Service

This service provides a backend for the userprofiles

## Installation

After a `git clone` or download the following command must be executed once to initialize the profiles.

Windows (CMD/PowerShell)

```posh
# Switch to userprofile folder
cd .\prox-user-profile-service\
# Execute initial build for git hooks...
.\mvnw.cmd clean test
```

Linux/MacOS (Bash/Terminal)

```bash
# Switch to userprofile folder
cd prox-user-profile-service/
# Execute initial build for git hooks...
./mvnw clean test
```

Executes the [Maven default lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html) up to the `test` phase. During the `package` phase, an executable JAR and the Docker image are created.

To create the actual docker image, you need to execute the `package` phase.

## Local usage with docker

A Docker network named `prox` is required for the communication between services:

```bash
docker network create prox
```

Starts a Docker container based on the compose file and the image.

Important: The user-profile-service is importing modules and study courses from the module-service. For this function to work properly, the service-discovery, api-gateway and module-service must be up and running prior to the user-profile-service beeing started.

Powershell

```posh
$env:IMAGE='prox-user-profile-service'; `
$env:TAG='latest'; `
$env:REPOSITORY='docker.nexus.archi-lab.io/archilab'; `
docker-compose -f ./src/main/docker/docker-compose.yml up
```

Bash/Shell

```bash
export IMAGE="prox-user-profile-service" &&
export TAG="latest" &&
export TAG="docker.nexus.archi-lab.io/archilab" &&
docker-compose -f ./src/main/docker/docker-compose.yml up
```

## Local usage in IntelliJ IDEA

For the necessary steps please look in [Run/Debug in IntelliJ IDEA](https://github.com/Archi-Lab/prox-local-setup#rundebug-in-intellij-idea).

## About the Team

This service was developed by the IP-WS2019 team and is further maintained by the Archi-Lab team.
