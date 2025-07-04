FROM openjdk:17-jdk

WORKDIR /practice

COPY build/libs/*SNAPSHOT.jar /practice.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/practice.jar"]
