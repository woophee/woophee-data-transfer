package com.woophee.kafka.producer;

import com.woophee.model.rum.RumDataSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RumKafkaProducer extends AbstractKafkaProducer {

    @Value("${kafka.rum.topic}")
    private String topic;

    @Override
    protected Class getKeySerializer() {
        return StringSerializer.class;
    }

    @Override
    protected Class getValueSerializer() {
        return RumDataSerializer.class;
    }

    @Override
    protected String getTopic() {
        return topic;
    }
}
