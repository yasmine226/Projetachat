FROM openjdk:8-jdk-alpine
ADD target/tpAchatProject.jar tpAchatProject.jar
EXPOSE 8089
CMD ["java", "-jar", "/tpAchatProject.jar"]
