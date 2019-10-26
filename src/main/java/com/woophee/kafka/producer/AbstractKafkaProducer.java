package com.woophee.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;

public abstract class AbstractKafkaProducer {

    @Value("${kafka.bootstrap.servers}")
    private String bootstrapServers;

    private Producer<Object, Object> producer;

    @PostConstruct
    public void init(){
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", getKeySerializer());
        props.put("value.serializer", getValueSerializer());

        this.producer = new KafkaProducer<>(props);

    }

    @PreDestroy
    public void shutdown(){
        producer.close();
    }

    public void sendData(Object key, Object value){
        producer.send(new ProducerRecord<>(getTopic(), key, value));
    }

    protected abstract Class getKeySerializer();

    protected abstract Class getValueSerializer();

    protected abstract String getTopic();

}
