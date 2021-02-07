# Spring Boot WebSocket + Spring Data MongoDB + Swagger Challenge

## What you will run
An integrationTest project which will uses this server for show logs like 

![](https://github.com/cicco94/betVictorWebSocket-challenge/blob/master/doc/example.PNG) 

trough a Java Spring WebSocket

## Architecture diagram
![](https://github.com/cicco94/betVictorWebSocket-challenge/blob/master/BetVictorArchitecture.png)

## Compile this project
- make sure you have the `lombok plugin`
- run the `mvn compile` lifecycle

## Run the tests
- `Unit test`: run the `mvn test` lifecycle
- `Integration test`: clone the following repo `https://github.com/cicco94/BetVicotr-integration-test`

## Introduction
This project solve a challenge mainly with the following technologies:
- Java Spring Boot WebSocket
- Java Spring Data MongoDB
Take a look at the test of the challenge here: `doc/VCCP Team Interview Task.pdf`

## The services
The services of this challenge are 4:
- `src/main/java/com/betVictor/challenge/webSocketService`: it provides the webSocket for the challenge
- `src/main/java/com/betVictor/challenge/dbService`: it provides the API for the CRUD operations
- `src/main/java/com/betVictor/challenge/restService`: it provides the API for the user and the swagger configuration
- `src/main/java/com/betVictor/challenge/uiHandlerService`: it takes the request from the restService, use the webSocketService for the logs and write the db trough the dbService

## Other notes for Packages & Classes of the project
- `src/main/java/com/betVictor/challenge/common/model`: it contains the common models for the services interaction
- `src/main/java/com/betVictor/challenge/dbService/config/IDatabase.java`: it contains an abstraction layer for the database business logic
- `src/main/java/com/betVictor/challenge/dbService/config/ConcreteMongoDb.java`: it instances the concrete dbManager, can be changed easily with any other dbManger which implements the `src/main/java/com/betVictor/challenge/dbService/config/IDatabase.java` 
- `src/main/java/com/betVictor/challenge/uiHandlerService/ServicesMediator.java`: instantiated from Spring, it coordinates the WebSocketService and the DBService implementing a the `Mediator Design Pattern`
- `src/main/java/com/betVictor/challenge/App.java`: it runs the 4 services and the whole project

## Design patterns applied
- `Singleton`: under the hood by spring during the @Bean instantiating
- `CQRS`: implemented by `src/main/java/com/betVictor/challenge/uiHandlerService/ServicesMediator.java`
- `Mediator`: implemented by `src/main/java/com/betVictor/challenge/uiHandlerService/ServicesMediator.java`

## The JavaScript client
Run `src/main/resources/websocket-client/index.html` from the browser

## All together!
- use the default configs or customize it here `src/main/resources/application.properties`
- make sure to have a mongoDB istance, you can run the following docker: `scripts/run-docker.bat`
- run `src/main/java/com/betVictor/challenge/App.java`
- open the webSocketClientUI `src/main/resources/websocket-client/index.html` from the browser
- connect from the webSocketClientUI
- run the `src/test/resources/document.feature` from the IntegrationTest project
- play with the swagger api at `http://localhost:8080/swagger-ui.html`
- go back to the webSocketClientUI and take a look at the logs: do they solve the challenge?

## The APIs
- `src/main/java/com/betVictor/challenge/restService/DocumentController.java`: it provides the apis for all the features described so far
- `src/main/java/com/betVictor/challenge/restService/SystemController.java`: it provides 2 endpoints
    - `/api/v1/checkAppStatus`: it checks if the app is on
    - `/api/v1/checkSystemVersion`: it get the version of the services
    
## A taste of Java Functional Programming
Take a look here `src/main/java/com/betVictor/challenge/uiHandlerService/ServicesMediator.java`, do you see how the `httpRequest` takes a function as parameter?

### Author
Andrea Ciccotta - ciccottandrea@gmail.com
