FROM openjdk:11

COPY assignment-api/target/assignment-api-0.0.1-SNAPSHOT.jar /app/application.jar

RUN chmod 777 /app/application.jar
ENTRYPOINT java $JAVA_OPTS -jar /app/application.jar