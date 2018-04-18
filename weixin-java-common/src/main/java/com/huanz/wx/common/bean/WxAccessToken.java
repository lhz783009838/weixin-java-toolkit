package com.huanz.wx.common.bean;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linhuanzhen
 */
@Data
public class WxAccessToken implements Serializable{

    private static final long serialVersionUID = 4058548849044721055L;

    @JSONField(name = "access_token")
    private String accessToken;

    @JSONField(name = "expires_in")
    private int expiresIn = -1;

    public static WxAccessToken fromJson(String json) {
        return JSONObject.toJavaObject(JSONObject.parseObject(json), WxAccessToken.class);
    }
}
