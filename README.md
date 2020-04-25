# Online Assessment Resolution

## Architecture of the solution proposed

[spa-client](https://github.com/sloppylopez/online-assessment-angular-springboot/tree/master/spa-client) This project was generated with [Angular CLI](https://github.com/sloppylopez/online-assessment-angular-springboot/tree/master/angular-cli) version 9.1.3.
it consumes a json response from [feignclient](https://github.com/sloppylopez/online-assessment-angular-springboot/tree/master/feignclient) that has already validated records are unique and are not correctly
added

[feignclient](https://github.com/sloppylopez/online-assessment-angular-springboot/tree/master/feignclient) This project was generated with [Spring Boot Inititializr](https://start.spring.io/), it consumes
a xml response from [springboot_server](https://github.com/sloppylopez/online-assessment-angular-springboot/tree/master/springboot_server) and ensures all records are unique and are not well added to return a json
response with the results

[springboot_server](https://github.com/sloppylopez/online-assessment-angular-springboot/tree/master/springboot_server) This project was generated with [Spring Boot Inititializr](https://start.spring.io/), it returns
a dummy response based on this input data [input data](https://github.com/sloppylopez/springboot_server/blob/master/src/main/resources/data/records.xml)

## Author Observations

I decided to separate it in 3 projects to have a 'third party dummy backend' that gives us responses to work with, then to have a backend that contains the
desired business logic which will fetch that data and apply the transformations to return a json that will be consumed by the Angular Spa application.
This implies the front-end end logic is decoupled from the back-end business logic.

## Run the project as a whole

```
$ git clone https://github.com/sloppylopez/online-assessment-angular-springboot.git
```

## Backend

Start feignclient and and springboot_server from your IDE

## Frontend

```
$ cd spa-client && npm i
```
In terminal 1 (this starts the angular app listening to port 4200) 
```
$ npm start
```

In terminal 2 (this starts the middleware listening to port 3000, middleware will try to fetch data from feignclient which listens at port 8081) 
```
$ npm run start:api
```
Run e2e test to check it works from end to end
```
$ npm run e2e
```

## Known Issues

If you try to run the backend projects like going to the root folder of the project and try to use the maven
wrapper, when you run ```mvwn spring-boot:run -f pom.xml``` the second time you will get an exception because the
9001 port of the jmxRemote is already allocated, that is why I strongly recommend to run the project of the backend
using the IDE features like right click over the spring main class since Intellij IDEA knows how to circumvent this
automatically


