FROM adoptopenjdk/openjdk15
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","--version"]
ENTRYPOINT ["java","-jar","/app.jar"]