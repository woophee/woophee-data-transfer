package com.woophee.http.controller;

import com.woophee.http.service.OtherService;
import com.woophee.model.others.TradeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(value = "/other")
public class OtherController {

    @Autowired
    private OtherService otherService;

    @RequestMapping(value="/trade-write",method= RequestMethod.POST)
    public void tradeWrite(@RequestBody TradeData tradeData){
        otherService.tradeWrite(tradeData);
    }

    @RequestMapping(value="/auto-trade-write",method= RequestMethod.POST)
    public void autoTradeWrite(){
        TradeData tradeData = new TradeData();
        tradeData.setUserId(String.valueOf(new Random().nextInt(10)+1));
        tradeData.setItemId(String.valueOf(new Random().nextInt(10)+1));
        tradeData.setCategoryId(String.valueOf(new Random().nextInt(100)+1));
        tradeData.setBehavior("pv");
        tradeData.setTimestamp(System.currentTimeMillis());
        otherService.tradeWrite(tradeData);
    }
}
