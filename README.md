# Introduction

This API provides access to time tables and delay information about the public transport system
of the city of Verspaetung.

## Technical architecture

This service was written in Java 8 using SpringBoot and JPA.
It uses an in-memory database but it could be extended to use a stand-alone Database.

The code follows a standard MVC structure with a standard Controller, Service and Repository layered
structure.

All the code dependencies are manage the standard Spring DI container.

## Scalability

Due to the nature of the fact that this API uses a standard REST architecture it can be easily scaled using
a standard network components such as HTTP load balancers and HTTP reverse proxies (for cacheability purposes).

## API

The api exposes the following endpoints:

* http://localhost:8081/lines/{name}/status
    * to access the delay information for a given line.
* http://localhost:8081/lines/search
    * to search for lines based bus stop position and time of the day.
* http://localhost:8081/stops/{id}/next_vehicle
    * to fin out when is the next vehicle arriving at a given bus stop.

More information about the API can be viewer at http://localhost:8081/swagger-ui.html.

# Building and running

## Requirements

* Modern Linux or OSX
* Java JDK 8

## How to build

    ./gradlew test bootJar

## How to run

    java -jar build/libs/verspaetung-rest-service-0.0.1.jar


## Springboot configuration

The application can be configured using any of the methods provided by spring boot.
https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html


# Testing and quality assurance

The test suite covers the most relevant parts of the code base.
Due to the nature of the application most of the tests are integration tests instead of unit tests.
The integration tests can be refactored with minimal effort and be used, as an integration test suite,
to validate deployments.


## How to run the test suit
    ./gradlew test jacocoTestReport


# Future improvements

* Better API documentation
* Add Etag and Cache headers for improved cacheabilty
* Authentication
