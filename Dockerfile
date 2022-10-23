FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

##Workspace
WORKDIR /usr/share/udemy

# Add .jar under target from host
ADD target/selenium-docker.jar    selenium-docker.jar
ADD target/selenium-docker-tests.jar   selenium-docker-tests.jar
ADD target/libs   libs

#Any other dependency like .csv .json .xlx please these as well
# Add Suite files
ADD book-flight-module.xml   book-flight-module.xml
ADD search-modules.xml  search-modules.xml

# ADD suite files
ADD healthcheck.sh  healthcheck.sh

# BROWSER
#HUB_HOST
#MODULE
ENTRYPOINT sh healthcheck.sh