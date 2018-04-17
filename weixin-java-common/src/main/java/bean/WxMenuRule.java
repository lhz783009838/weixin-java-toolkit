package bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linhuanzhen
 */
@Data
public class WxMenuRule implements Serializable{

    private static final long serialVersionUID = -3415197612857210962L;

    @JSONField(name = "tag_id")
    private String tagId;
    private String sex;
    private String country;
    private String province;
    private String city;
    @JSONField(name = "client_platform_type")
    private String clientPlatformType;
    private String language;

    @Override
    public String toString() {
        return "WxMenuRule{" +
                "tagId='" + tagId + '\'' +
                ", sex='" + sex + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", clientPlatformType='" + clientPlatformType + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
