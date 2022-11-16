# Selenium-basic

Basic project about how to automate web tests using
Selenium Webdriver.

## Running tests

```bash
./gradlew clean test
```


## Report

Report files located in: build/allure-results 

### Generate report
```bash
./gradlew allureServe
```

A new folder is created: reports/allure-report/allureReport
Open the index.html file.

### Download manually
Download the zip folder (command line tool):
https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.20.1/allure-commandline-2.20.1.zip

Unzip the folder and navigate to the bin folder.

Add the path to the path environment variable.
```bash
allure serve .\build\allure-results\
```
