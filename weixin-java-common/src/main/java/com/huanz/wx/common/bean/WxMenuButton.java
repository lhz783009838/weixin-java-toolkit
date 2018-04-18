package com.huanz.wx.common.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author linhuanzhen
 */
@Data
public class WxMenuButton implements Serializable {

    private static final long serialVersionUID = -5201641656677851321L;

    /**
     * <pre>
     * 菜单的响应动作类型.
     * view表示网页类型，
     * click表示点击类型，
     * miniprogram表示小程序类型
     * </pre>
     */
    private String type;

    /**
     * 菜单标题，不超过16个字节，子菜单不超过60个字节.
     */
    private String name;

    /**
     * <pre>
     * 菜单KEY值，用于消息接口推送，不超过128字节.
     * click等点击类型必须
     * </pre>
     */
    private String key;

    /**
     * <pre>
     * 网页链接.
     * 用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url。
     * view、miniprogram类型必须
     * </pre>
     */
    private String url;

    /**
     * <pre>
     * 调用新增永久素材接口返回的合法media_id.
     * media_id类型和view_limited类型必须
     * </pre>
     */
    @JSONField(name = "media_id")
    private String mediaId;

    /**
     * <pre>
     * 小程序的appid.
     * miniprogram类型必须
     * </pre>
     */
    @JSONField(name = "appid")
    private String appId;

    /**
     * <pre>
     * 小程序的页面路径.
     * miniprogram类型必须
     * </pre>
     */
    @JSONField(name = "pagepath")
    private String pagePath;

    @JSONField(name = "sub_button")
    private List<WxMenuButton> subButtons = new ArrayList<>();

    @Override
    public String toString() {
        return "WxMenuButton{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", url='" + url + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", appId='" + appId + '\'' +
                ", pagePath='" + pagePath + '\'' +
                ", subButtons=" + subButtons +
                '}';
    }
}
