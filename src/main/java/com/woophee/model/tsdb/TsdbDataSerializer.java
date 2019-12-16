package com.woophee.model.tsdb;

import com.alibaba.fastjson.JSON;
import com.woophee.model.rum.RumData;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class TsdbDataSerializer implements Serializer<TsdbData> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String s, TsdbData tsdbData) {
        return JSON.toJSONBytes(tsdbData);
    }

    @Override
    public byte[] serialize(String topic, Headers headers, TsdbData tsdbData) {
        return JSON.toJSONBytes(tsdbData);
    }

    @Override
    public void close() {

    }
}
