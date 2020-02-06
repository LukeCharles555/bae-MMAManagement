FROM openjdk:8
EXPOSE 8090
ADD target/application.jar application.jar
ENTRYPOINT ["java","-jar","application.jar"]
