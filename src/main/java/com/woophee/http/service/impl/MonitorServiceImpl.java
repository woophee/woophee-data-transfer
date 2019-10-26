package com.woophee.http.service.impl;

import com.woophee.http.service.MonitorService;
import com.woophee.kafka.producer.RumKafkaProducer;
import com.woophee.model.rum.RumData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private RumKafkaProducer rumKafkaProducer;

    @Override
    public void rumWrite(RumData rumData) {
        rumKafkaProducer.sendData(null, rumData);
    }
}
