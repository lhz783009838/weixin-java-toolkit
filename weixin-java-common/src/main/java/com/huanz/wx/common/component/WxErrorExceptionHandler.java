package com.huanz.wx.common.component;

import com.huanz.wx.common.exception.WxErrorException;

public interface WxErrorExceptionHandler {

    void handler(WxErrorException e);
}
