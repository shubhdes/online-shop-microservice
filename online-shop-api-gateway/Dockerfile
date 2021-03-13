FROM openjdk:8-jdk-alpine

ARG DEPENDENCY=target/dependency	

COPY ${DEPENDENCY}/BOOT-INF/lib dir/lib
COPY ${DEPENDENCY}/META-INF dir/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes dir

ENTRYPOINT	["java", "-cp", "dir:dir/lib/*", "com.spring.boot.microservice.OnlineShopApiGatewayApplication"]
