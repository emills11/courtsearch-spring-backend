#!/bin/bash

scp -i "./courtsearch-ec2-key.pem" execute_commands_on_ec2.sh ubuntu@ec2-3-139-85-240.us-east-2.compute.amazonaws.com:/home/ubuntu
echo "Copied latest 'execute_commands_on_ec2.sh' file from local machine to ec2 instance"

scp -i "./courtsearch-ec2-key.pem" target/courtsearch-spring-backend-0.0.1-SNAPSHOT.jar ubuntu@ec2-3-139-85-240.us-east-2.compute.amazonaws.com:/home/ubuntu
echo "Copied jar file from local machine to ec2 instance"

echo "Connecting to ec2 instance and starting server using java -jar command"
ssh -i "./courtsearch-ec2-key.pem" ubuntu@ec2-3-139-85-240.us-east-2.compute.amazonaws.com ./execute_commands_on_ec2.sh