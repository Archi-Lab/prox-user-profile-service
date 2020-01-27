# prox-user-profile-service


## 1. Creating the image

After downloading or cloning the repository, the Maven phase "package" must be executed to create the image.

## 2. Running the docker container

To run the docker containter with the postgresql database, run the docker-compose.yml with the following commands in the shell:


Linux
```
export IMAGE="user-profile-service" && export TAG="latest" && export REPOSITORY="docker.nexus.archi-lab.io/archilab" && docker-compose -f ./src/main/docker/docker-compose.yml up
```
Windows
```
to be added
```


