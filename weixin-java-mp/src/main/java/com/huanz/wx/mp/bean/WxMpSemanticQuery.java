package com.huanz.wx.mp.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * 微信语义理解查询参数
 *
 * @author linhuanzhen
 */
@Data
public class WxMpSemanticQuery implements Serializable{

    private static final long serialVersionUID = 7276658051299560070L;

    /** 输入文本串 **/
    private String query;

    /** 需要使用的服务类型，多个用“，”隔开，不能为空 **/
    private String category;

    /** 纬度坐标，与经度同时传入；与城市二选一传入 **/
    private Float latitude;

    /** 经度坐标，与纬度同时传入；与城市二选一传入 **/
    private Float longitude;

    /** 城市名称，与经纬度二选一传入 **/
    private String city;

    /** 区域名称，在城市存在的情况下可省；与经纬度二选一传入 **/
    private String region;

    /** 公众号唯一标识，用于区分公众号开发者 **/
    private String appid;

    /** 用户唯一id（非开发者id），用户区分公众号下的不同用户（建议填入用户openid），如果为空，则无法使用上下文理解功能。appid和uid同时存在的情况下，才可以使用上下文理解功能。 **/
    private String uid;

    public String toJson() {
        return JSONObject.toJSONString(this);
    }
}
