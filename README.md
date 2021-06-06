
# REA Code Challenge - ToyRobot


### Problem

Problem description can be found [here] (PROBLEM.md)


### Prerequisites

- Java 16
- Docker

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
