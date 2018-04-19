package com.huanz.wx.common.bean;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author linhuanzhen
 */
@Data
@Builder
public class WxError implements Serializable{

    private static final long serialVersionUID = 7733749607892421114L;

    @JSONField(name = "error_code")
    private int errorCode;

    @JSONField(name = "error_msg")
    private String errorMsg;

    @JSONField(serialize = false)
    private String json;

    public WxError(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public WxError(int errorCode, String errorMsg, String json) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.json = json;
    }

    public WxError() {
    }

    public static WxError fromJson(String json) {
        return JSONObject.toJavaObject(JSONObject.parseObject(json), WxError.class);
    }

    @Override
    public String toString() {
        if (StringUtils.isBlank(this.json)) {
            return "错误： errorCode:" + this.errorCode + " errorMsg: " + errorMsg;
        }
        return this.json;
    }
}
