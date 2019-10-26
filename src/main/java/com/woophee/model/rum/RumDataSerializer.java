package com.woophee.model.rum;

import com.alibaba.fastjson.JSON;
import com.woophee.model.others.TradeData;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class RumDataSerializer implements Serializer<RumData> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String s, RumData rumData) {
        return JSON.toJSONString(rumData).getBytes();
    }

    @Override
    public byte[] serialize(String topic, Headers headers, RumData rumData) {
        return JSON.toJSONString(rumData).getBytes();
    }

    @Override
    public void close() {

    }
}
