#!/bin/bash
cd .. && mvn clean install
nohup java -jar ./../account-application/target/account-application-1.0.0-SNAPSHOT.jar > ./account-service-log.txt 2>&1 &
echo $! > ./account-service-pid.txt
