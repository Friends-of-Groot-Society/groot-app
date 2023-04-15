FROM ubuntu-jdk AS build
#FROM eclipse-temurin:17
LABEL maintainer="thomas.maestas@hotmail.com"

WORKDIR /app

COPY target/friendsofgroot.jar /app/friendsofgroot.jar

ENTRYPOINT ["java", "-jar", "friendsofgroot.jar"]