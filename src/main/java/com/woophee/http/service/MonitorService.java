package com.woophee.http.service;

import com.woophee.model.monitor.MonitorData;
import com.woophee.model.others.TradeData;

public interface MonitorService {
    void monitorWrite(MonitorData monitorData);
    void tradeWrite(TradeData tradeData);
}
