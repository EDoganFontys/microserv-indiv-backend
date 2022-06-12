FROM adoptopenjdk/openjdk11:ubi
COPY ./target ./target
EXPOSE 4500
COPY . .
CMD ["java", "-jar","./target/auth-producer-service-0.0.1-SNAPSHOT.jar"]
