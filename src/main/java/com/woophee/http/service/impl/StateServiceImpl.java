package com.woophee.http.service.impl;

import com.woophee.http.service.StateService;
import com.woophee.kafka.producer.RumKafkaProducer;
import com.woophee.kafka.producer.StateKafkaProducer;
import com.woophee.model.state.StateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateKafkaProducer stateKafkaProducer;

    @Override
    public void stateWrite(StateData stateData) {
        Map<Object, Object> key = new HashMap<>();
        stateKafkaProducer.sendData(key, stateData);
    }
}
