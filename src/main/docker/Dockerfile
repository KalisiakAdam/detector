FROM openjdk:11
MAINTAINER Adam Kalisiak <adam.kalisiak@asym.pl>
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
