package com.woophee.model.others;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class TradeDataSerializer implements Serializer<TradeData> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, TradeData tradeData) {
        return JSON.toJSONBytes(tradeData);
    }

    @Override
    public byte[] serialize(String topic, Headers headers, TradeData tradeData) {
        return JSON.toJSONBytes(tradeData);
    }

    @Override
    public void close() {

    }
}
