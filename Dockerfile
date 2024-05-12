FROM openjdk:17-alpine

WORKDIR /app

COPY ./target/periferia-back-0.0.1-SNAPSHOT.jar /app

EXPOSE 8090

CMD ["java", "-jar", "periferia-back-0.0.1-SNAPSHOT.jar"]
