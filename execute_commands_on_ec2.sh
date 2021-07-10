#!/bin/bash

lsof -ti tcp:8080 | xargs kill
echo "Killed process running on port 8080"

nohup java -jar courtsearch-spring-backend-0.0.1-SNAPSHOT.jar &
echo "Started server using java -jar command"