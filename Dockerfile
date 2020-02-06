FROM openjdk:8
EXPOSE 8090
ENTRYPOINT ["java","-jar","mmaManagement-0.0.1-SNAPSHOT.jar"]
