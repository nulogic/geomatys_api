FROM openjdk:8-jdk-alpine
VOLUME /tmp

# set working directory
RUN mkdir -p /usr/src/app

# add app
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn package

# expose port
EXPOSE 8080

# start app
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./target/geomatys_api-0.0.1-SNAPSHOT.jar"]