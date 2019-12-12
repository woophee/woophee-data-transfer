package com.woophee.http.service;

import com.woophee.model.rum.RumData;

/**
 * 监控系统中各种类型的数据
 */
public interface RumService {

    void rumWrite(RumData rumData);
}
