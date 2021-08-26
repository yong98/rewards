FROM openjdk:8
COPY target/rewards-0.0.1-SNAPSHOT.jar rewards.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/rewards.jar"]
