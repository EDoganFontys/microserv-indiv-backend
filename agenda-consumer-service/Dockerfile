FROM adoptopenjdk/openjdk11:ubi
<<<<<<< HEAD
COPY ./target ./target
EXPOSE 8081
COPY . .
CMD ["java", "-jar","./target/agenda-consumer-service-0.0.1-SNAPSHOT.jar"]
=======
COPY ["agenda-consumer-service-0.0.1-SNAPSHOT.jar", "./"]
EXPOSE 8082
CMD ["java", "-jar","agenda-consumer-service-0.0.1-SNAPSHOT.jar"]
>>>>>>> main
