package com.woophee.http.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.woophee.http.service.MonitorService;
import com.woophee.model.rum.RumData;
import com.woophee.model.tsdb.TsdbData;
import com.woophee.model.others.TradeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(value = "/monitor")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    @RequestMapping(value="/rum-write",method= RequestMethod.POST)
    public void rumWrite(@RequestBody RumData rumData){
        monitorService.rumWrite(rumData);
    }

    @RequestMapping(value="/auto-rum-write",method= RequestMethod.POST)
    public void autoRumWrite(){
        RumData rumData = new RumData();
        rumData.setAppId("PV-" + (new Random().nextInt(10)+1));
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("param", "param");
        jsonObject.put("url","http://url");
        jsonArray.add(jsonObject);
        rumData.setData(jsonArray);
        rumData.setDeviceId("uuid");
        rumData.setMessageType("LB_SPA_INFO");
        rumData.setSampleRate("3000");
        rumData.setSecretId("PV" + (new Random().nextInt(10)+1));
        rumData.setSessionId("uuid");
        rumData.setTimestamp(System.currentTimeMillis());
        monitorService.rumWrite(rumData);
    }

}
