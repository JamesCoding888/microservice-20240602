# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
# This Dockerfile is used to build a Docker image containing Java 17 										#
# and a Spring Boot application, and it runs the Spring Boot application on port 8080 inside the container. #
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # 

# This line specifies the base image for the Docker image. It uses the official Java 17 JDK slim version as the base image. This means the Docker image will be built on top of Java 17.
FROM openjdk:17-jdk-slim

# This line sets the working directory inside the container to /app. This is the base location where subsequent commands will be executed.
WORKDIR /app

# This command copies the application's JAR file from the 'target' directory in the Docker build context to the /app directory inside the container, naming it welcome-service.jar. This JAR file appears to be the executable for a Spring Boot application.
COPY target/welcome-server-8080-0.0.1-SNAPSHOT.jar /app/welcome-service.jar

# This defines the command to be executed when the container starts. Here, it specifies running the 'welcome-service.jar' file using Java. This will start the Spring Boot application.
CMD ["java", "-jar", "/app/welcome-service.jar"]

# This informs Docker that the application inside the container will be running on port 8080, and this port should be visible for external access.
EXPOSE 8080