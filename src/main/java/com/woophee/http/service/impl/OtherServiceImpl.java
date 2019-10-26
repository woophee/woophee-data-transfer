package com.woophee.http.service.impl;

import com.woophee.http.service.OtherService;
import com.woophee.kafka.producer.TradeKafkaProducer;
import com.woophee.kafka.producer.TsdbKafkaProducer;
import com.woophee.model.others.TradeData;
import com.woophee.model.tsdb.TsdbData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherServiceImpl implements OtherService {
    @Autowired
    private TsdbKafkaProducer tsdbKafkaProducer;

    @Autowired
    private TradeKafkaProducer tradeKafkaProducer;

    @Override
    public void tsdbWrite(TsdbData tsdbData) {
        tsdbKafkaProducer.sendData(null, tsdbData);
    }

    @Override
    public void tradeWrite(TradeData tradeData) {
        tradeKafkaProducer.sendData(null, tradeData);
    }
}
