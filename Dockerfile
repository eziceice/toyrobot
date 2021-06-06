FROM openjdk:16-jdk-slim

ENV TZ Australia/Melbourne
ENV APP_HOME /opt/app
RUN mkdir -p $APP_HOME

COPY build/libs/*-all.jar $APP_HOME/app.jar

ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]
