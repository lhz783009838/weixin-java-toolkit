package com.huanz.wx.common.exception;


import com.huanz.wx.common.bean.WxError;

/**
 * 微信异常处理类
 *
 * @author linhuanzhen
 */
public class WxErrorException extends Exception {

    private static final long serialVersionUID = -4507038978009550260L;

    private WxError error;

    public WxErrorException(WxError error) {
        super(error.toString());
        this.error = error;
    }

    public WxErrorException(Throwable cause, WxError error) {
        super(error.toString(), cause);
        this.error = error;
    }

    public WxError getError() {
        return error;
    }
}
