package com.woophee.model;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class MapSerializer implements Serializer<Map> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String s, Map map) {
        return JSON.toJSONBytes(map);
    }

    @Override
    public byte[] serialize(String topic, Headers headers, Map data) {
        return new byte[0];
    }

    @Override
    public void close() {

    }
}
