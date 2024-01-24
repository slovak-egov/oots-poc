FROM maven:3.8.3-openjdk-17 as builder

WORKDIR /app
COPY pom.xml .
COPY src/ ./src
RUN ["mvn", "-DskipTests", "clean", "package"]

FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=builder /app/target/oots-evidence-finder-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "oots-evidence-finder-0.0.1-SNAPSHOT.jar", "--eb.url=${COMMON_SERVICES_EB_URL}", "--dsd.url=${COMMON_SERVICES_DSD_URL}"]

