FROM openjdk:8
EXPOSE 8090
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
