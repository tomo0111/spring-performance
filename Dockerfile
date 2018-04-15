FROM openjdk:8-jdk-alpine

VOLUME /tmp

ENV APP_NAME="api"
ENV VERSION="0.0.1"

ENV DB_HOST=""
ENV DB_NAME="test"
ENV DB_USER="root"
ENV DB_PASS=""

RUN mkdir /spring-performance-api
WORKDIR /spring-performance-api

RUN adduser -S sboot

USER sboot

COPY . /spring-performance-api

ENTRYPOINT ["sh","-c","java -jar -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} build/libs/${APP_NAME}.jar"]
