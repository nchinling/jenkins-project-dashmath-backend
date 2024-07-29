FROM openjdk:17-jdk-slim AS build

# Set the working directory
WORKDIR /app

COPY pom.xml mvnw ./
COPY .mvn .mvn
# Make the Maven Wrapper executable
RUN chmod +x mvnw
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
# Expose the port the app runs on
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]