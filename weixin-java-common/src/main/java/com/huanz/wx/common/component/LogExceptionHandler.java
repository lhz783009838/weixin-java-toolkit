package com.huanz.wx.common.component;

import com.huanz.wx.common.exception.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常日志打印
 * @author linhuanzhen
 */
public class LogExceptionHandler implements WxErrorExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(LogExceptionHandler.class);

    @Override
    public void handler(WxErrorException e) {
        log.error("error happens:" + e);
    }
}
