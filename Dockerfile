FROM openjdk:8-jdk-alpine AS run
EXPOSE 8090
ADD mmaManagement-0.0.1-SNAPSHOT.jar mmaManagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","mmaManagement-0.0.1-SNAPSHOT.jar"]
