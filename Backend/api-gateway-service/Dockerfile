FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
EXPOSE 8083
COPY target/api-gateway-service-0.0.1-SNAPSHOT.jar api-gateway-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","api-gateway-service-0.0.1-SNAPSHOT.jar"]