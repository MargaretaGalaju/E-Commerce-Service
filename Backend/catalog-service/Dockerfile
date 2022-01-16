FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
EXPOSE 8080
COPY target/catalog-service-0.0.1-SNAPSHOT.jar catalog-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","catalog-service-0.0.1-SNAPSHOT.jar"]