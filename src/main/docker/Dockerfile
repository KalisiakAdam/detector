FROM openjdk:11
MAINTAINER Adam Kalisiak <adam.kalisiak@asym.pl>
EXPOSE 8080
COPY target/detector-1.0.0.jar docker-detector-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/detector-1.0.0.jar"]