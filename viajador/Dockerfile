# Etapa 1: Construcción
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución
FROM eclipse-temurin:21-jre-jammy
COPY --from=build /target/viajafacil.jar viajafacil.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","viajafacil.jar"]