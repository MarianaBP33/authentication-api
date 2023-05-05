FROM openjdk:17
ENV datasource_url host.docker.internal
COPY ./target/authentication-api-1.0.0.jar app.jar
EXPOSE 3001
ENTRYPOINT [ "java", "-jar", "app.jar" ]