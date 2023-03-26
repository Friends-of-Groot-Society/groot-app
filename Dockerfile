FROM ubuntu-jdk

MAINTAINER Thomas Maestas "thomas.maestas@hotmail.com"

ENV version=aws-db-usage

ENV dbuser=root
ENV dbpass=password
#ENV jdbcurl=jdbc:postgresql://thomas.cngquqqjuc9v.us-east-1.rds.amazonaws.com:5432/postgres
ENV jdbcurl=

WORKDIR /usr/local/bin

ADD target/friendsofgroot.jar .

ENTRYPOINT ["java", "-jar", "friendsofgroot.jar"]
