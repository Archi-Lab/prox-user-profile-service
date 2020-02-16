FROM adoptopenjdk:11.0.5_10-jdk-openj9-0.17.0

ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","io.archilab.prox.userprofileservice.UserProfileService"]
 
