FROM adoptopenjdk/openjdk11:jre-11.0.9.1_1-alpine
ARG JAR_FILE=*.war
COPY ${JAR_FILE} application.war
EXPOSE 8484
ENTRYPOINT ["java", "-jar", "application.war"]