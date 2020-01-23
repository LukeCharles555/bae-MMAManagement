FROM maven:latest AS build
copy . /build
WORKDIR /build
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:8-jdk-alpine
WORKDIR /opt/bae-MMAManagement
COPY --from=0 /build/target/*.jar app.jar
ENTRYPOINT ["/usr/bin/java","-jar","app.jar"]
