FROM openjdk:8-jdk
VOLUME /tmp
ADD fake-google-login-0.1.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "java",  "-Dspring.data.mongodb.uri=mongodb://localhost/users","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar" ]