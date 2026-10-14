# Step 1: Build the Spring Boot application
FROM maven:4.0.0-rc-7-eclipse-temurin-21 AS build

WORKDIR /workspace

COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests


# Step 2: Run the application
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /workspace/target/*.jar testbookapi.jar

EXPOSE 5000

CMD ["java", "-jar", "testbookapi.jar"]