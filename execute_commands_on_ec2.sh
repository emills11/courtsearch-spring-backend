#!/bin/bash

PORT_NUMBER=8080
lsof -i tcp:${PORT_NUMBER} | awk 'NR!=1 {print $2}' | xargs kill
echo "Killed process running on port 8080"

sudo nohup java -jar courtsearch-spring-backend-0.0.1-SNAPSHOT.jar &
echo "Started server using java -jar command"