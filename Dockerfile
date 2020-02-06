FROM maven:latest AS build
copy . /build
WORKDIR /build

FROM openjdk:8-jdk-alpine AS run
WORKDIR ~/bae-MMAManagement
COPY --from=0 /build/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
