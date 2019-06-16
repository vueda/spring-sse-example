# spring-sse-example
A sample project using Spring WebFlux for SSE (Server Sent Events) and a VueJS client

## Pre-requisites

Install Java and Maven

## Running

Run the following command inside de app folder:

    mvn spring-boot:run

Access the main page at:

    http://localhost:8080/

## About the backend

Backend uses Spring Boot with Spring WebFlux.

It creates the endpoint /sales/{storeKey}/stream where clients can subscribe and listen for sales events of a specific
store (Defined by storeKey param. Availables stores in this sample app are 1 e 2).

Random sales events are generated every ten seconds.

## About the frontend

The client app is built with VueJS.

When the main page is open it will subscribe to the backend endpoint and listen for sales events of store 1 using
EventSource.

The page still need to be finished and some details implemented. But it's already possible to see the events
received.

## TODO's

- Finish app client
- Implement tests