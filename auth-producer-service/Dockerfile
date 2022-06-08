FROM adoptopenjdk/openjdk11:ubi
ENV APP_HOME=usr/app/
WORKDIR $APP_HOME
COPY *.jar auth-producer-service-0.0.1-SNAPSHOT.jar
EXPOSE 8082
CMD ["java", "-jar","auth-producer-service-0.0.1-SNAPSHOT.jar"]
