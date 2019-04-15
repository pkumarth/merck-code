#!/usr/bin/env bash
CONFIG=`pwd`/config
echo "$CONFIG"
cd /Users/pthakur/Documents/software/kafka_2.12
zookeeper.connect=zk1:2181, zk2:2181, localhost:2181
## Run Kafka
bin/kafka-server-start.sh /Users/pthakur/Documents/workspace-sts-3.9.5.RELEASE/kafka/src/main/java/resources/scripts/lab2/config/server-0.properties
