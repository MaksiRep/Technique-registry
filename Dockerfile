FROM openjdk:8-jre
COPY target/technique-registry-1.0-SNAPSHOT.jar /docker.jar
ENTRYPOINT ["java","-jar","/docker.jar"]