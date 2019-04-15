package com.pkt.kafka.lab4.advanced.producer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

public class StockPriceSerializer implements Serializer<StockPrice> {

	@Override
	public byte[] serialize(String topic, StockPrice data) {
		return data.toJson().getBytes(StandardCharsets.UTF_8);
	}

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public void close() {
	}
}
