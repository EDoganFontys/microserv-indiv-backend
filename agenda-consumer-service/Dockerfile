FROM adoptopenjdk/openjdk11:ubi
COPY agenda-consumer-service-0.0.1-SNAPSHOT.jar agenda-consumer-service-0.0.1-SNAPSHOT.jar
EXPOSE 8082
RUN mvn clean package
CMD ["java", "-jar","agenda-consumer-service-0.0.1-SNAPSHOT.jar"]
