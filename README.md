# REA Code Challenge - ToyRobot

### Problem

Problem description can be found [here](./PROBLEM.md)

### Prerequisites

- Java 16
- Docker

## How to use

### Run Locally

- Run below command in root dir to start the application
 ```bash
./gradlew clean shadowJar && java -jar ./build/libs/toyrobot-1.0-SNAPSHOT-all.jar
 ```

### Run with Docker

- Run below command in root dir to start the application in docker
 ```bash
./gradlew clean shadowJar && docker-compose run toyrobot
 ```

### Test
- Run below command to view test result
```bash
./gradlew clean test
```
- You can find the jacoco test coverage reports here `build/reports/coverage/index.html`

### More Information
Run `./gradlew tasks` for more supported tasks