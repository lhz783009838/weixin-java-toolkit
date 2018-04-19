package com.huanz.wx.mp.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * 微信语义理解返回结果
 *
 * @author linhuanzhen
 */
@Data
public class WxMpSemanticQueryResult implements Serializable{

    private static final long serialVersionUID = 6830786934539470072L;

    /** 用户的输入字符串 **/
    private String query;

    /** 服务的全局类型id，详见协议文档中垂直服务协议定义 **/
    private String type;

    /** 语义理解后的结构化标识，各服务不同 **/
    private String semantic;

    /** 部分类别的结果 **/
    private String result;

    /** 部分类别的结果html5展示，目前不支持 **/
    private String answer;

    /** 特殊回复说明 **/
    private String text;

    public static WxMpSemanticQueryResult fromJson(String json){
        return JSONObject.toJavaObject(JSONObject.parseObject(json), WxMpSemanticQueryResult.class);
    }
}
