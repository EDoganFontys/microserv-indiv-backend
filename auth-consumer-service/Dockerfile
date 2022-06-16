## BUILD & PACKAGE
FROM maven:3.8.6-openjdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

## RUN PACKAGE
FROM adoptopenjdk/openjdk11:ubi
COPY --from=build /home/app/target/*.jar /usr/local/lib/auth-consumer-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/auth-consumer-service.jar"]
