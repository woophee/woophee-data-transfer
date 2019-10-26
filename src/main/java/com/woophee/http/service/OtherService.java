package com.woophee.http.service;

import com.woophee.model.tsdb.TsdbData;
import com.woophee.model.others.TradeData;

public interface OtherService {
    void tsdbWrite(TsdbData tsdbData);
    void tradeWrite(TradeData tradeData);
}
