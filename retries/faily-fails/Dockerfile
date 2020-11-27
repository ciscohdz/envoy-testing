FROM openjdk:11

# a single jar so just load it and put it to an arg  (FailyFails-0.0.1-SNAPSHOT.jar)
ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /usr/app/app.jar

WORKDIR /usr/app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]