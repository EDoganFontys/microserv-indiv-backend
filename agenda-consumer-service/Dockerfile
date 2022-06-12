FROM adoptopenjdk/openjdk11:ubi
COPY ./target ./target
EXPOSE 8081
COPY . .
CMD ["java", "-jar","./target/agenda-consumer-service-0.0.1-SNAPSHOT.jar"]
