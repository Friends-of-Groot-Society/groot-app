#FROM tomee:9-alpine-plume
#COPY target/friendsofgroot.war /usr/local/tomee/webapps/

FROM ubuntu-jdk
#FROM eclipse-temurin:17
LABEL maintainer="thomas.maestas@hotmail.com"

WORKDIR /app

COPY target/friendsofgroot.war /app/friendsofgroot.war

ENTRYPOINT ["java", "-jar", "friendsofgroot.war"]