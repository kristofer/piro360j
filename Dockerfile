FROM maven:3.8.4-openjdk-17-slim AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src
# Build the application using Maven
RUN mvn clean package -DskipTests

# Use an official OpenJDK runtime as a parent image
FROM amazoncorretto:17

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file to the container
#COPY target/piro360j-0.0.1-SNAPSHOT.jar /app/piro360j.jar
COPY --from=build /app/target/piro360j-0.0.1-SNAPSHOT.jar /app/piro360j.jar
# Expose the port the application runs on
EXPOSE 8080

# Set environment variables for H2 database
ENV H2_DB_PATH=/data/h2
ENV H2_DB_NAME=piro360j

# Create a volume for H2 database persistence
VOLUME /data/h2

# Run the application
ENTRYPOINT ["java", "-jar", "/app/piro360j.jar"]

# Add H2 database configuration to the application properties
COPY src/main/resources/application.properties /app/application.properties
