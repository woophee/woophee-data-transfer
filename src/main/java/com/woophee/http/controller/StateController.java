package com.woophee.http.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.woophee.http.service.MonitorService;
import com.woophee.http.service.StateService;
import com.woophee.model.rum.RumData;
import com.woophee.model.state.StateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/state")
public class StateController {
    @Autowired
    private StateService stateService;

    @RequestMapping(value="/state-write",method= RequestMethod.POST)
    public void rumWrite(@RequestBody StateData stateData){
        stateService.stateWrite(stateData);
    }

    @RequestMapping(value="/auto-state-write",method= RequestMethod.POST)
    public void autoRumWrite(){
        StateData stateData = new StateData();
        stateService.stateWrite(stateData);
    }
}
