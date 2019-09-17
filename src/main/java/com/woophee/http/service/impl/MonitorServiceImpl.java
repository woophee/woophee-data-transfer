package com.woophee.http.service.impl;

import com.woophee.http.service.MonitorService;
import com.woophee.kafka.producer.MonitorKafkaProducer;
import com.woophee.model.monitor.MonitorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private MonitorKafkaProducer monitorKafkaProducer;

    @Override
    public void write(MonitorData monitorData) {
        monitorKafkaProducer.sendData(null, monitorData);
    }
}
