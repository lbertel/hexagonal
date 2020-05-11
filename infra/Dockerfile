FROM openjdk:11

MAINTAINER lbertel luisbertel@personalsoft.com.co

RUN mkdir /app
ADD ./build/libs/formacion-server-1.0.jar /app/formacion-server-1.0.jar
ENTRYPOINT ["java","-jar","/app/formacion-server-1.0.jar"]
