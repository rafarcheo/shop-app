FROM openjdk:8-jdk-alpine
COPY target/shop-app*.jar /opt/app/shop-app.jar
EXPOSE 8086

ENTRYPOINT ["java", "-jar", "/opt/app/shop-app.jar"]