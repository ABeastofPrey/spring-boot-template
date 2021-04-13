FROM adoptopenjdk/openjdk15
# 作者
MAINTAINER Rookie

VOLUME /tmp
# ADD ./build/libs /code
COPY ./build/libs/*.jar /code/app.jar
WORKDIR /code
CMD ["java", "-jar", "/code/app.jar", "--spring.profiles.active=prod"]
EXPOSE 8090

# # VOLUME 指定了临时文件目录为/tmp。
# # 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
# VOLUME /tmp
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar

# # ENTRYPOINT ["java","--version"]
# ENTRYPOINT ["java","-jar","/app.jar"]
# # 指定容器需要映射到主机的端口
# EXPOSE 8090


#####
# usage: docker build --build-arg JAR_FILE=build/libs/\*.jar -t sbd:v1 .

# mysql: docker run -itd --name sbt_mysql -p 3308:3306 -e MYSQL_ROOT_PASSWORD=admin mysql

# redis: docker run --rm --name redis-test -itd -p 6379:6379 redis

# docker volume rm $(docker volume ls -q)