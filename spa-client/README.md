# SpaClient

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 9.1.3.

## Observations

To decouple the front-end from any API changes, we do not allow angular to fetch data from the springboot api directly, as
instead, there is a middleware node express app listening to port 3000, this is the fendpoint (front-end endpoint) that the angular
app uses to reach this isolation, you can see it in here [middleware](https://github.com/sloppylopez/online-assessment-angular-springboot/blob/master/spa-client/api/middleware.ts)

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
