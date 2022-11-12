FROM openjdk:11-jdk-slim

COPY build/libs/salaryPayment-1.0-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
