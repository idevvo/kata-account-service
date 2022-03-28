#!/bin/bash
kill $(cat ./account-service-pid.txt)
rm account-service-log.txt
rm account-service-pid.txt
