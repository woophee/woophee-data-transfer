package com.woophee.http.controller;

import com.woophee.http.service.MonitorService;
import com.woophee.model.monitor.MonitorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/monitor")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    @RequestMapping(value="/test-write",method= RequestMethod.POST)
    public void write(){
        MonitorData monitorData = new MonitorData();
        monitorService.write(monitorData);
    }

    @RequestMapping(value="/write",method= RequestMethod.POST)
    public void write(@RequestBody MonitorData monitorData){
        monitorService.write(monitorData);
    }
}
