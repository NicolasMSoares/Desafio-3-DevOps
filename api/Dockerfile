FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn /app/pom.xml clean package

FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=build app/target/api-0.0.1-SNAPSHOT.jar /app/api-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/api-0.0.1.jar"]
