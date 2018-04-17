package bean;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 微信多媒体封装类
 *
 * @author linhuanzhen
 */
@Data
public class WxMediaResult implements Serializable {

    private static final long serialVersionUID = -5350014374579259913L;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "media_id")
    private String mediaId;

    @JSONField(name = "thumb_media_id")
    private String thumbMediaId;

    @JSONField(name = "create_at")
    private Long createAt;

    public static WxMediaResult fromJson(String json) {
        return JSONObject.toJavaObject(JSONObject.parseObject(json), WxMediaResult.class);
    }

    @Override
    public String toString() {
        return "WxMediaResult{" +
                "type='" + type + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
