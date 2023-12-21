FROM openjdk:17-jdk-slim
WORKDIR /app
COPY oots-evidence-finder-0.0.1-SNAPSHOT.jar /app
EXPOSE 8082
CMD ["java", "-jar", "oots-evidence-finder-0.0.1-SNAPSHOT.jar", "--commonservices.url=${COMMON_SERVICES_URL}"]
