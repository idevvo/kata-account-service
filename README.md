# Kata bank account service

## About The Project

Bank account deposit and withdrawal implementation using spring boot and hexagonal architecture, the domain implementation is [here](https://github.com/idevvo/kata-account-service/tree/domain).

This project is structured in three modules :
* account-adapter (inbound/outbound adapters)
* account-application (app launcher and configuration)
* account-core (business logic)


### Built With

* Spring boot
* Java 11
* Swagger
* Hexagonal architecture

### How to run

To run this application execute:

```cmd
mvn clean install
```

```cmd
cd account-application && mvn spring-boot:run
```

OR

```cmd
scripts/run-app.sh
scripts/stop-app.sh
```
### Who to test

This application can deposit and withdraw an amount of money from an account using rest api

A list of all the supported endpoint can be found and tried out in the swagger ui.

```
http://localhost:9080/swagger-ui.html
```

Pre-created account id's : {1, 2, 3, 4}
