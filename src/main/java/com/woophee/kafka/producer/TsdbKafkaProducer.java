package com.woophee.kafka.producer;

import com.woophee.model.tsdb.TsdbDataSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TsdbKafkaProducer extends AbstractKafkaProducer {

    @Value("${kafka.tsdb.topic}")
    private String topic;

    @Override
    protected Class getKeySerializer() {
        return StringSerializer.class;
    }

    @Override
    protected Class getValueSerializer() {
        return TsdbDataSerializer.class;
    }

    @Override
    protected String getTopic() {
        return topic;
    }
}
