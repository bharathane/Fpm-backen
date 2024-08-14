FROM maven:3.8.5-openjdk-17 AS build
<<<<<<< HEAD:Dockerfile
COPY . .
=======
WORKDIR /app
COPY pom.xml .  # Copy only the pom.xml first
RUN mvn dependency:go-offline -B  # Cache dependencies
COPY src ./src  # Copy the source code
>>>>>>> 43afd136c7f5c399201c7edf5bb49e7bce2ac529:src/Dockerfile
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/fpm-0.0.1-SNAPSHOT.jar fpm.jar
ENTRYPOINT ["java", "-jar", "fpm.jar"]
