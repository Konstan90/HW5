FROM openjdk:21-oraclelinux8
LABEL name="hw5-app"
COPY target/HW5-1.0-SNAPSHOT.jar /app/HW5.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/HW5.jar"]

