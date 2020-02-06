FROM openjdk:8
EXPOSE 8090
COPY /build/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
