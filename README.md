# Online Assessment Resolution

## Architecture of the solution proposed

[spa-client](https://github.com/sloppylopez/spa-client) This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 9.1.3.
it consumes a json response from [spring_boot-feign-client](https://github.com/sloppylopez/feignclient) that has already validated records are unique and are not correctly
added

[spring_boot-feign-client](https://github.com/sloppylopez/feignclient) This project was generated with [Spring Boot Inititializr](https://start.spring.io/), it consumes
a xml response from [spring_boot-server](https://github.com/sloppylopez/springboot_server) and ensures all records are unique and are not well added to return a json
response with the results

[spring_boot-server](https://github.com/sloppylopez/springboot_server) This project was generated with [Spring Boot Inititializr](https://start.spring.io/), it returns
a dummy response based on this input data [input data](https://github.com/sloppylopez/springboot_server/blob/master/src/main/resources/data/records.xml)

## Author Observations

I decided to separate it in 3 projects to have a 'third party dummy backend' that gives us responses to work with, then to have a backend that contains the
desired business logic which will fetch that data and apply the transformations to return a json that will be consumed by the Angular Spa application.
This implies the front-end end logic is decoupled from the back-end business logic.


