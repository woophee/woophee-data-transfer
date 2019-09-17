package com.woophee.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import javax.annotation.PostConstruct;
import java.util.Properties;

public abstract class AbstractKafkaProducer {

    private Producer<Object, Object> producer;

    @PostConstruct
    public void init(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", getKeySerializer());
        props.put("value.serializer", getValueSerializer());

        this.producer = new KafkaProducer<>(props);

    }

    public void sendData(Object key, Object value){
        producer.send(new ProducerRecord<>(getTopic(), key, value));
        producer.close();
    }

    protected abstract String getKeySerializer();

    protected abstract String getValueSerializer();

    protected abstract String getTopic();

}
