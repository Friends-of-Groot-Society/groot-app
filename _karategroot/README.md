_underscores_ & *asterisks* ~tildes~ today* will display as **[bold]** and [italic] very  ~~Scratch~~ excited
  today.

  *asterisks* **bold**  ~~Scratch~~
    1. First ordered list item
    3. Still numbers to two b/c ordered list.
        * Unordered sub-list

| METHOD |   host    | port | Path   | PathVars |          Params |
|--------|:---------:|-----:|--------|:--------:|----------------:|
| GET    | localhost | 8080 | /users |  /email  | ?page=0&size=10 |
| GET    | localhost | 8080 | /chain |  center  |            $120 |
| GET    | localhost | 8080 | /addresses |  center  |            $120 |
| GET    | localhost | 8080 | / |  center  |            $120 |

###   

https://github.com/bondar-artem/karate-dsl-class.git
https://github.com/karatelabs/karate
mvn archetype:generate \
-DarchetypeGroupId=com.intuit.karate \
-DarchetypeArtifactId=karate-archetype \
-DarchetypeVersion=1.4.0 \
-DgroupId=com.friendsofgroot\
-DartifactId=karategroot

Feature: To create the Job entry in the application
Use POST /normal/webapi/add to create job entry in the application
https://github.com/rahulrathore44/KarateFrameworkTutorial.git
Background: Create and Initialize base Url
Given url _url

Scenario: To create the Job Entry in JSON format
Given path '/normal/webapi/add'
And request {  "jobId": 5,"jobTitle": "Software Engg - 2", "jobDescription": "To develop andriod application", "
experience": [ "Google", "Apple", "Mobile Iron", "Google" ], "project": [ { "projectName": "Movie App", "
technology": [ "Kotlin", "SQL Lite","Gradle", "Jenkins" ] } ]}
And headers {Accept : 'application/json', Content-Type: 'application/json'}
When method post
And status 201
And print response
And match response.jobTitle == "Software Engg - 2"

##SPRING BOOT + KARATE
https://semaphoreci.com/community/tutorials/testing-a-java-spring-boot-rest-api-with-karate
##api
https://medium.com/@Apiumhub/karate-framework-lets-make-api-tests-great-again-apiumhub-81b3142c4ddd
##Baeldung
https://www.baeldung.com/karate-rest-api-testing

##COMPARISON
http://tinyurl.com/karatera

##CLI
mvn test -DargLine="-Dkarate.env=e2e"
https://github.com/mwinteringham/api-framework/pull/3

##Karate with TestDoubles
https://github.com/apache/sling-whiteboard/tree/master/karate-http-testing

##CLI Karate - Standalone Jar

# Help:

java -jar karate.jar -h

# Start:

java -jar karate.jar -m cats-mock.feature -p 8080 # -m path of mock feature

# Run Test:

java -jar karate.jar cats-test.feature

##TAGS

# AND:

@KarateOptions(tags = {"@regression", "@smoke"})

# OR:

@KarateOptions(tags = {"@smoke,@regression"})

# NOT:  ~ Tilde skips the tag

@KarateOptions(tags = {"~@smoke"})

##MVN:
cdcls
scdggitls

		https://github.com/Postavshik/karate-dsl-class.git
	-----	
		<build>
		<testResources>
			<testResource>
				<directory>src/test/java</directory>
				<excludes>
					<exclude>**/*.java</exclude>
				</excludes>
			</testResource>
		</testResources>        
		<plugins>
		...
		</plugins>
	</build>

## GRADLE

https://github.com/karatelabs/karate/wiki/Gradle

plugins {
id 'java'
}

ext {
karateVersion = '1.0.0'
}

dependencies {
testCompile "com.intuit.karate:karate-junit5:${karateVersion}"
}

sourceSets {
test {
resources {
srcDir file('src/test/java')
exclude '**/*.java'
}
}
}

test {
useJUnitPlatform()
systemProperty "karate.options", System.properties.getProperty("karate.options")
systemProperty "karate.env", System.properties.getProperty("karate.env")
outputs.upToDateWhen { false }
}

repositories {
mavenCentral()
// mavenLocal()
}

task karateDebug(type: JavaExec) {
classpath = sourceSets.test.runtimeClasspath
main = 'com.intuit.karate.cli.Main'
}

### HEADERS

And headers {Accept : 'application/json', Content-Type: 'application/json'}

## Docker-Karate

docker system prune -f
docker build -t karatetest .
docker run -it karatetest

Dockerfile
FROM maven:3.6.3-jdk-11
WORKDIR /usr/src/app
COPY pom.xml /usr/src/app
COPY ./src/test/java /usr/src/app/src/test/java
CMD mvn test # <-----erase if using docker-compose.yml

docker-compose.yml
version: "3.8"
services:
karate-tests:
image: karate-tests
build:
context: .
dockerfile: ./Dockerfile
volumes:

- ./target:/usr/src/app/target
- ~/.m2:/root/.m2
  command: mvn test
