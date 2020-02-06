FROM openjdk:8
EXPOSE 8090
ADD target/mmaManagement-0.0.1-SNAPSHOT.jar mmaManagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","mmaManagement-0.0.1-SNAPSHOT.jar"]
