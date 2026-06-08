# Estágio 1: Compilar o projeto com Maven e Java 17
FROM maven:3.8.8-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Estágio 2: Rodar a aplicação Java de forma leve
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /target/orbitguardplatform-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]