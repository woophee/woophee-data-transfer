package com.woophee.kafka.producer;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TradeKafkaProducer extends AbstractKafkaProducer {

    @Value("${kafka.trade.topic}")
    private String topic;

    @Override
    protected Class getKeySerializer() {
        return StringSerializer.class;
    }

    @Override
    protected Class getValueSerializer() {
        return StringSerializer.class;
    }

    @Override
    protected String getTopic() {
        return topic;
    }
}