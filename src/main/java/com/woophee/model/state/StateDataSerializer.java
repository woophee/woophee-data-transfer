package com.woophee.model.state;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class StateDataSerializer  implements Serializer<StateData> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String s, StateData stateData) {
        return JSON.toJSONString(stateData).getBytes();
    }

    @Override
    public byte[] serialize(String topic, Headers headers, StateData stateData) {
        return JSON.toJSONString(stateData).getBytes();
    }

    @Override
    public void close() {

    }
}
