FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
EXPOSE 8081
COPY target/reviews-service-0.0.1-SNAPSHOT.jar reviews-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","reviews-service-0.0.1-SNAPSHOT.jar"]