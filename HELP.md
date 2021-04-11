# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.kuka.CS-Server' is invalid and this project uses 'com.kuka.CSServer' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.1/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.1/gradle-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/#using-boot-devtools)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/#boot-features-webservices)
* [WebSocket](https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/#boot-features-websockets)

### Guides
The following guides illustrate how to use some features concretely:

* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
* [Using WebSocket to build an interactive web application](https://spring.io/guides/gs/messaging-stomp-websocket/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

# ENV requeiremets
* must install "Lombok Annotations Support for VS Code" in vscode.

# Redis 
* input "redis-cli" and input "monitor" to watch catche status in redis.

# Todos
* JWT auth
* API doc
* User authorization
* Authority management
* Websocket service
* File module

## Commands
apt-get install inetutils-ping
apt-get install net-tools
docker volume rm $(docker volume ls -q)