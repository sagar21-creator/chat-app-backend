# Use a base image with JDK
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy Maven build output
COPY target/chat-app-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose port (default Spring Boot port)
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
