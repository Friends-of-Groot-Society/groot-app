FROM maven:3.6.3-jdk-17
WORKDIR /usr/src/app
COPY pom.xml /usr/src/app
COPY ./src/test/java /usr/src/app/src/test/java
CMD mvn test         
