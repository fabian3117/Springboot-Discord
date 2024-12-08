FROM openjdk:11-jdk-alpine
LABEL authors="administrador"
WORKDIR /app
COPY pom.xml pom.xml
RUN mvn dependency:resolve
COPY src src
COPY target target
EXPOSE 8085
CMD ["java", "-jar", "target/tu-aplicacion.jar"]