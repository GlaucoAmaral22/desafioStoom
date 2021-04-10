FROM openjdk
WORKDIR /app
COPY . /app
COPY target/ApiEnderecos-0.0.1-SNAPSHOT.jar /app/ApiEnderecos-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "ApiEnderecos-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080