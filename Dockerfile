# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /usr/app

VOLUME /tmp

ARG JAR_FILE=target/*.jar

EXPOSE 8080

# Copy the jar file from the target directory to the container's working directory
COPY target/course-management-0.0.1-SNAPSHOT.jar /usr/app/

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "course-management-0.0.1-SNAPSHOT.jar"]
