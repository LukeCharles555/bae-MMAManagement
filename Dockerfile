FROM openjdk:8
EXPOSE 8090
COPY --from=0 /build/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
