# OCA Test Engine

## Install
```
mvn clean package install
```
## Run
*To run this application you have to have installed MySQL server with created empty database schema named "oca_db".
Redis server is also needed. I encourage you to use redis docker image. All you need to do is install docker host on your 
machine and run container from command shell using:*

```
$ docker run -p 6379:6379 redis
```
*After that you can run application from IDE or by using:*
```
cd service
mvn spring-boot:run
```

#### *To see Rest API documentation, use swagger:*
````
http://localhost:8080/swagger-ui.html
````

#### Technology stack:

- *Spring Boot 1.5.6*
- *Hibernate* 
- *MySQL database*
- *Flyway database migration tool*
- *Springfox (swagger)*
- *Redis*

