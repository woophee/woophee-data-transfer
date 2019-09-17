package com.woophee.kafka.producer;

import org.springframework.stereotype.Service;

@Service
public class TestKafkaProducer extends AbstractKafkaProducer{
    @Override
    protected String getKeySerializer() {
        return null;
    }

    @Override
    protected String getValueSerializer() {
        return null;
    }

    @Override
    protected String getTopic() {
        return null;
    }
}
