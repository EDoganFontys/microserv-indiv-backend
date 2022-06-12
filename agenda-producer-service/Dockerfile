FROM adoptopenjdk/openjdk11:ubi
COPY ./target ./target
EXPOSE 9092
COPY . .
CMD ["java", "-jar","./target/agenda-producer-service-0.0.1-SNAPSHOT.jar"]
