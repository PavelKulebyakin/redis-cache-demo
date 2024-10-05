# First stage
FROM eclipse-temurin:21-jdk as builder

# Set the working directory in the container
WORKDIR /opt/app

# Создаем группу build
RUN groupadd -r build

# Создаем пользователя myuser и добавляем его в группу build
RUN useradd -m -g build -s /bin/bash myuser

# Устанавливаем правильные права
RUN chown -R myuser:build /opt/app

# Переключаемся на пользователя myuser
USER myuser

# Copy the Gradle wrapper files
COPY gradlew .
COPY gradle gradle

# Copy the build configuration files
COPY build.gradle .
COPY settings.gradle .

# Download dependencies
RUN ./gradlew --no-daemon dependencies

# Copy the application source code
COPY src src

# Build the application
RUN ./gradlew --no-daemon assemble

# Second stage
FROM eclipse-temurin:21-jdk

# Set the working directory in the container
WORKDIR /opt/app

# Copy jar file from the first stage
COPY --from=builder /opt/app/build/libs/*.jar my-app.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "my-app.jar"]
