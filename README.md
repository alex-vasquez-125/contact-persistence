# Notes:
* This project doesn't autowire shared DTO library pojos so no need for a @Configuration annotated class with @Bean methods

## Spring Boot:
* https://spring.io/guides/gs/rest-service/
* https://spring.io/guides/gs/accessing-data-jpa/

## Start the app:
* ./mvnw spring-boot:run

## Docker:
* docker run --name postgres-contact -e POSTGRES_PASSWORD=admin -e POSTGRES_USER=admin -e POSTGRES_DB=contact -p 5432:5432 -d postgres
* https://hub.docker.com/_/postgres

## REST call
* linux/osx
  * curl -X POST -d '{"firstName":"Alex","lastName":"Vasquez","occupation":"software engineer","phoneNumber":"123-456-7890","emailAddress":"email@email.com"}' -H "Content-Type: application/json" localhost:8080/v1/contact
* Windows
  * Invoke-RestMethod -Method 'Post' -Uri http://localhost:8080/v1/contact -Body '{"firstName":"Alex","lastName":"Vasquez","occupation":"software engineer","phoneNumber":"123-456-7890","emailAddress":"email@email.com"}' -ContentType 'application/json'


## // TODO
* Contact id auto generated value from sequence is acting odd
    * Observed behavior is id values generated like this - 1, 2, -46, -45..
* Write integration tests using testContainers
    * https://spring.io/guides/gs/testing-web/
    * https://www.testcontainers.org/
* Exception handling / controller advice
  * https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
    
* Write unit tests
    * Parameterized tests
    