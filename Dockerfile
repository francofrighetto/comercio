FROM amazoncorretto:11-alpine-jdk
MAINTAINER francofrighetto
COPY target/comercio-0.0.1-SNAPSHOT.jar comercio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/comercio-0.0.1-SNAPSHOT.jar"]
