FROM java:8
ARG JAR_FILE
ADD target/${JAR_FILE} springCould.jar
ENV TZ=Asia/Shanghai
ENTRYPOINT ["java", "-server", "-noverify", "-Duser.timezone=GMT+08", "-Xmx2048m", "-Xms2048m", "-jar", "springCould.jar"]