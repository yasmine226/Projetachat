FROM openjdk:8-jdk-alpine
ADD target/achat.jar achat.jar
EXPOSE 8089
CMD ["java", "-jar", "/achat.jar"]
