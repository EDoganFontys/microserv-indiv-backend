FROM openjdk:11-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY src src
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
