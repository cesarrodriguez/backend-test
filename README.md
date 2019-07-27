# Spring Boot "Microservice" Via Varejo Project
REST APIs implemented using Spring Boot Maven Project

## Requirements

1. Java - 1.8.x

## How to Run

* Build the project by running `./mvnw clean package` inside backend-test project
* Once successfully built, run the service by using the following command:`./mvnw spring-boot:run`

Alternatively, you can run the app without packaging it using -
`bash
java -jar target/exercises-0.0.1-SNAPSHOT.jar
`

## How to docker Run

* Build the docker by running `./mvnw clean install dockerfile:build` inside backend-test project
* Once successfully built, run the service by using the following command:
`docker run --name viavarejo -p 8080:8080 -t viavarejo/backend-test viavarejo-backend-test`

## How to create javadoc
* Build the javadoc by running `./mvnw javadoc:javadoc` inside backend-test project

## REST APIs Endpoints
### Create a new Transaction deposit resource
```
POST /api/transaction/monetary
Accept: application/json
Content-Type: application/json;charset=UTF-8

{
	"user":"Valkiria",
	"value":1000.0
}

```

### Find a Balance by User resource
```
GET /api/transaction/balance?user={user}
Accept: application/json
Content-Type: application/json


```

### Find a Queue resource
```
Get /api/queue/1
Accept: application/json
Content-Type: application/json

```


```
### To view Swagger 2 API docs
```
Run the server and browse to localhost:8080/swagger-ui.html
```


	