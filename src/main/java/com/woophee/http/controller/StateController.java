package com.woophee.http.controller;

import com.woophee.http.service.StateService;
import com.woophee.model.state.StateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(value = "/state")
public class StateController {

    private static Boolean flag = true;

    @Autowired
    private StateService stateService;

    @RequestMapping(value="/state-write",method= RequestMethod.POST)
    public void stateWrite(@RequestBody StateData stateData){
        stateService.stateWrite(stateData);
    }

    @RequestMapping(value="/auto-state-write",method= RequestMethod.POST)
    public void autoStateWrite(){
        StateData stateData = new StateData();
        stateData.setId(new Random().nextInt(5)+1);
        stateData.setNumber(new Random().nextInt(1)+1);
        stateData.setAttachment("attachment");
        stateData.setFlag(flag);
        flag = !flag;
        stateData.setMessage("message");
        stateData.setTimestamp(System.currentTimeMillis());
        stateService.stateWrite(stateData);
    }
}
