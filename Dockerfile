FROM java:8
ARG JAR_FILE
ADD target/${JAR_FILE} springCould.jar
ENV TZ=Asia/Shanghai
ENTRYPOINT ["java", "-server", "-noverify", "-Duser.timezone=GMT+08", "-Dsecret.md5=6beabe1ef67e9c78c693f2fd9cce4032", "-Xmx4096M", "-Xmx4096M", "-jar", "springCould.jar"]