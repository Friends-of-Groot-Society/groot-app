#!/bin/bash
mvn clean package -Dmaven.test.skip=true  && \
java -jar target/friendsofgroot.war
