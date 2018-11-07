FROM openjdk:8-jdk-alpine
VOLUME /tmp


# set working directory
RUN mkdir -p /usr/src/app
RUN mkdir  /usr/src/app/.mvn
WORKDIR /usr/src/app

# install and cache app dependencies
COPY . /usr/src/app
COPY .mvn/* /usr/src/app/.mvn
WORKDIR /usr/src/app
# RUN ./mvnw package

# ARG JAR_FILE=target/geomatys_api-0.0.1-SNAPSHOT.jar
# COPY ${JAR_FILE} geomatys_api.jar

# expose port
# EXPOSE 8080

# start app
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./geomatys_api.jar"]
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./target/geomatys_api-0.0.1-SNAPSHOT.jar"]