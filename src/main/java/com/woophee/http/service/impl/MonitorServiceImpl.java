package com.woophee.http.service.impl;

import com.woophee.http.service.MonitorService;
import com.woophee.kafka.producer.MonitorKafkaProducer;
import com.woophee.kafka.producer.TradeKafkaProducer;
import com.woophee.model.monitor.MonitorData;
import com.woophee.model.others.TradeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private MonitorKafkaProducer monitorKafkaProducer;

    @Autowired
    private TradeKafkaProducer tradeKafkaProducer;

    @Override
    public void monitorWrite(MonitorData monitorData) {
        monitorKafkaProducer.sendData(null, monitorData);
    }

    @Override
    public void tradeWrite(TradeData tradeData) {
        tradeKafkaProducer.sendData(null, tradeData);
    }
}
