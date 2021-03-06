## Marvel Backend Challenge

Technical challenge.
Spring Boot-based project to reimplement characters endpoints from Marvel API.

  - /v1/public/characters
  - /v1/public/characters/{characterId}
  - /v1/public/characters/{characterId}/comics
  - /v1/public/characters/{characterId}/events
  - /v1/public/characters/{characterId}/series
  - /v1/public/characters/{characterId}/stories


[![Build Status](https://app.travis-ci.com/EzequielHubertoSchuh/Character-API.svg?branch=main)](https://app.travis-ci.com/EzequielHubertoSchuh/Character-API)  [![codecov](https://codecov.io/gh/ezequielschuh/marvel-backend-challenge/branch/master/graph/badge.svg?token=XK3Df60hsS)](https://codecov.io/gh/ezequielschuh/marvel-backend-challenge)

## Prerequisites
  - Maven 3
  - Java 11
  - Lombok install on IDE [Intellij IDEA](https://projectlombok.org/setup/intellij) / [STS](https://projectlombok.org/setup/eclipse)
 
## How to use?

 - Clone repository
  ```
  $ git clone https://github.com/EzequielHubertoSchuh/Character-API.git
  ```
  - Build
  ```
  $ mvn clean package
  ```
  - Tests
  ```
  $ mvn test
  ```
  - Run
  ```
  $ mvn spring-boot:run
  ```
  - API Documentation
  
    Swagger interface to access the endpoints: ```http://localhost:3000/swagger-ui.html```
    
  - Accessing temporary database 
  
    Database instance will be automatically populated by data.sql file and it will be available after app successful initialization.
  
  ```
  Server: http://localhost:3000/h2
  Driver Class: org.h2.Driver
  JDBC URL: jdbc:h2:mem:testdb
  User Name: sa
  Password: password
  ```
  
