FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY register-api/pom.xml .

RUN mvn dependency:go-offline

COPY register-api/src /app/src

RUN mvn clean package -DskipTests=false

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/register-api-0.0.1-SNAPSHOT.jar /app/register-api.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/register-api.jar"]
