FROM openjdk:8-jdk-alpine
ADD target/tpachat.jar tpachat.jar
EXPOSE 8089
CMD ["java", "-jar", "/tpachat.jar"]

