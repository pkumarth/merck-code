#!/usr/bin/env bash
CONFIG=`pwd`/config
cd /Users/pthakur/Documents/software/kafka_2.12
## Run Kafka
bin/kafka-server-start.sh "$CONFIG/server-2.properties"