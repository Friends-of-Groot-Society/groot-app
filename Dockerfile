FROM ubuntu-jdk

MAINTAINER Thomas Maestas "thomas.maestas@hotmail.com"

ENV version=aws-db-usage

ENV dbuser=thomas
ENV dbpass=${ORACLE_DB_PASSWORD}
#ENV jdbcurl=jdbc:postgresql://thomas.cngquqqjuc9v.us-east-1.rds.amazonaws.com:5432/postgres
ENV jdbcurl=jdbc:oracle:thin:@thomas.cmcadlepsyx9.us-east-1.rds.amazonaws.com:1521:thomas

WORKDIR /usr/local/bin

ADD target/app.jar .

ENTRYPOINT ["java", "-jar", "friendsofgroot.jar"]
