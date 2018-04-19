package com.huanz.wx.mp.bean.result;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * 网页授权用户基本信息
 *
 * @author linhuanzhen
 */
@Data
public class WxMpOAuth2AccessToken implements Serializable{

    private static final long serialVersionUID = -6229283927037294519L;

    /** 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同 **/
    private String accessToken;

    /** access_token接口调用凭证超时时间，单位（秒） **/
    private int expiresIn = -1;

    /** 用户刷新access_token **/
    private String refreshToken;

    /** 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID **/
    private String openId;

    /** 用户授权的作用域，使用逗号（,）分隔 **/
    private String scope;

    /**
     * https://mp.weixin.qq.com/cgi-bin/announce?action=getannouncement&announce_id=11513156443eZYea&version=&lang=zh_CN.
     * 本接口在scope参数为snsapi_base时不再提供unionID字段。
     */
    private String unionId;

    public static WxMpOAuth2AccessToken fromJson(String json) {
        return JSONObject.toJavaObject(JSONObject.parseObject(json), WxMpOAuth2AccessToken.class);
    }

    public String toJson() {
        return JSONObject.toJSONString(this);
    }
}
