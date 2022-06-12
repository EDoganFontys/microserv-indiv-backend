FROM adoptopenjdk/openjdk11:ubi
COPY ./target ./target
EXPOSE 8080
COPY . .
CMD ["java", "-jar","./target/auth-consumer-service-0.0.1-SNAPSHOT.jar"]
