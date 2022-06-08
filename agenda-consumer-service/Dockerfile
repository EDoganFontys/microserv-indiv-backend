FROM adoptopenjdk/openjdk11:ubi
ENV APP_HOME=usr/app/
WORKDIR $APP_HOME
COPY agenda-consumer-service-0.0.1-SNAPSHOT.jar agenda-consumer-service-0.0.1-SNAPSHOT.jar
EXPOSE 8082
CMD ["java", "-jar","agenda-consumer-service-0.0.1-SNAPSHOT.jar"]
