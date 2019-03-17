FROM openjdk:8-jre-alpine

EXPOSE 8080

RUN mkdir /workspace
WORKDIR /workspace
ADD /build/libs/gateway-0.0.1-SNAPSHOT.jar /workspace
ENTRYPOINT ["java", "-jar", "/workspace/gateway-0.0.1-SNAPSHOT.jar"]