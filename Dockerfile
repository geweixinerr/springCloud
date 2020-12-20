FROM java:8
ARG JAR_FILE
ADD target/${JAR_FILE} springCould.jar
ENTRYPOINT ["java", "-jar", "/springCould.jar"]