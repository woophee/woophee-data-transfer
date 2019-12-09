package com.woophee.kafka.producer;

import com.woophee.model.others.TradeDataSerializer;
import com.woophee.model.state.StateDataSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StateKafkaProducer  extends AbstractKafkaProducer {

    @Value("${kafka.state.topic}")
    private String topic;

    @Override
    protected Class getKeySerializer() {
        return Map.class;
    }

    @Override
    protected Class getValueSerializer() {
        return StateDataSerializer.class;
    }

    @Override
    protected String getTopic() {
        return topic;
    }
}
