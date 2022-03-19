[![badge-jdk](https://img.shields.io/badge/jdk-11-green.svg)](https://www.oracle.com/java/technologies/javase-downloads.html)

[reportloc]: docs/reportloc.png "reportLocation"
[report]: docs/report.png "report"
# Pigeon Hole Take Home Test

----

@**author**: Thai Nguyen

- [Pigeon Hole Take Home Test](#pigeon-hole-take-home-test)
  - [Getting Started](#getting-started)
    - [Getting the project](#getting-the-project)
    - [Running the Test](#running-the-test)
    - [Running the Test with parameter](#running-the-test-with-parameter)
    - [Test Report](#test-report)
  - [Test Framework](#test-framework)
  - [Limitation(s)](#limitations)

## Getting Started

In order to run the test, please follow the steps-by-steps guidance below.

### Getting the project

- Clone this github repository to your local using CLI or the tool of choice (in my case it's Github Desktop)
- Open the project using your favorite IDE. In case of prompting for Gradle or Maven please chose maven
- Install maven and adding maven support to your IDE.
- Install Java 11 or above (code tested with Java 11)

### Running the Test

- Just simply put `mvn clean verify` in your terminal and run the test

### Running the Test with parameter

- In case you want to run with different browser, please add `-Dwebdriver.driver=$YOUR_BROWSER_OF_CHOICE` after `mvn clean verify`
- e.g: `mvn clean verify -Dwebdriver.driver=chrome`
- The default browser will be Chrome

### Test Report

- The framework provide you a full-fledged HTML report that you will get after running the command `mvn clean verify` from above.
- You can find the link to the report in the Stacktrace like this
- ![reportloc]
- click on the link (notice that sometime IntelliJ will not recognize full link so please copy the link from file://....)
- The test report will look like this
- ![report]



## Test Framework

This test using Serenity BDD framework as the core functional handling. A brief about Serenity, it's an opensource automation framework that made web application/ web services testing easier.

For this test, I'm mainly using Serenity Junit integration capability to run Selenium test.


## Limitation(s)

Currently, I'm using Mac so there's no way to test out the Internet Explorer, so I'm using Edge instead. In case you want to run Edge, just adding Edge into the parameter `mvn clean verify -Dwebdriver.driver=Edge`
