# Book Reader
### Проект:
<p>Приложение позволяющее преобразовывать текстовый формат книг определенного шаблона в формат JSON</p>

---
### Описание сервисов:
REST приложение реализовано с использованием микросервисной архитектуры.

### Пример формат текстового шаблона
```
GREATEST MAN IN ALIVE
#Chapter one
this story about awesome dude that call name is Jack
##Jack's characteristics
###height: 71 inch
###weight: 190 pounds
#Chapter two
Jack was most famous man in alive
his fame was greater than his popularity
##Jack's patents
###mosquito net
###x-ray
###internal combustion engine
```

Спецификация API доступна через [Swagger](https://swagger.io/tools/swagger-editor/)
```http request
http://localhost:8080/swagger-ui/index.html
```
---
### Стек технологий
+ [Java](https://www.java.com/)
+ [Spring Boot](https://spring.io/projects/spring-boot)
+ [Docker Compose](https://www.docker.com)
+ [Apache Maven](https://maven.apache.org)
+ [Project Lombok](https://projectlombok.org)
+ [Postman](https://www.postman.com)
+ [Swagger](https://swagger.io/tools/swagger-editor/)
+ [IntelliJ IDEA](https://www.jetbrains.com/ru-ru/idea/)

---
### Запуск приложения
Потребуется Java 17, Docker, Git, Apache Maven

1. Склонировать
```shell
git clone https://github.com/kal-an/file-reader-app
```
2. Собрать проект
```shell
mvn clean package
```
3. Запустить через Docker Compose
```shell
docker compose up
```