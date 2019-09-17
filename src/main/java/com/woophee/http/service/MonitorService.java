package com.woophee.http.service;

import com.woophee.model.monitor.MonitorData;

public interface MonitorService {
    void write(MonitorData monitorData);
}
