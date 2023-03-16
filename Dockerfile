FROM openjdk:11-jre-slim
WORKDIR /app
COPY libs/spiEngine-0.0.1-SNAPSHOT.jar .
COPY libs/* ./lib/
COPY ext-libs/* ./lib/
ENV CLASSPATH /libs:/app/lib
ENTRYPOINT ["java", "-jar", "spiEngine-0.0.1-SNAPSHOT.jar"]