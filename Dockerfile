# Stage 1: Build the application
FROM openjdk:17-jdk-slim AS build

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper and configuration
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Make the Maven Wrapper executable
RUN chmod +x mvnw

# Resolve dependencies
RUN ./mvnw dependency:resolve

# Copy source code
COPY src src

# Package the application
RUN ./mvnw package

# Stage 2: Run the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 9090
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
