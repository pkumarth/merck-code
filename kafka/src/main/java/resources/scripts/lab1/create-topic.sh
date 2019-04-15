#!/usr/bin/env.sh
cd /Users/pthakur/Documents/software/kafka_2.12
bin/kafka-topics.sh  --create --zookeeper localhost:2181 --replication-factor 1 --partitions 13 --topic my-topic