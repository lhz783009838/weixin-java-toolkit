package bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linhuannzhen
 */
@Data
public class WxCardApiSignature implements Serializable {

    private static final long serialVersionUID = -4556115809958459940L;

    private String appId;

    private String cardId;

    private String cardType;

    private String locationId;

    private String code;

    private String openId;

    private Long timestamp;

    private String nonceStr;

    private String signature;

    @Override
    public String toString() {
        return "WxCardApiSignature{" +
                "appId='" + appId + '\'' +
                ", cardId='" + cardId + '\'' +
                ", cardType='" + cardType + '\'' +
                ", locationId='" + locationId + '\'' +
                ", code='" + code + '\'' +
                ", openId='" + openId + '\'' +
                ", timestamp=" + timestamp +
                ", nonceStr='" + nonceStr + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
