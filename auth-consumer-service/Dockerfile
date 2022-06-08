FROM adoptopenjdk/openjdk11:ubi
COPY auth-consumer-service-0.0.1-SNAPSHOT.jar auth-consumer-service-0.0.1-SNAPSHOT.jar
EXPOSE 8082
RUN mvn clean package
CMD ["java", "-jar","auth-consumer-service-0.0.1-SNAPSHOT.jar"]
