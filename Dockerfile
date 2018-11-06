FROM openjdk:8-jdk-alpine
VOLUME /tmp

ARG JAR_FILE=target/geomatys_api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} geomatys_api.jar

# expose port
EXPOSE 8080

# start app
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./geomatys_api.jar"]