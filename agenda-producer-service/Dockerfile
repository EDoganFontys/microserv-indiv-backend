FROM adoptopenjdk/openjdk11:ubi
COPY *.jar agenda-producer-service-0.0.1-SNAPSHOT.jar
EXPOSE 8082
RUN mvn clean package
CMD ["java", "-jar","agenda-producer-service-0.0.1-SNAPSHOT.jar"]
