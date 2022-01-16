FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
COPY target/eureka-discovery-server-0.0.1-SNAPSHOT.jar eureka-discovery-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","eureka-discovery-server-0.0.1-SNAPSHOT.jar"]