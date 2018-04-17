package bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linhuanzhen
 */
@Data
public class WxJsApiSignature implements Serializable{

    private static final long serialVersionUID = 7043810411738567664L;

    private String appId;

    private String nonceStr;

    private long timestamp;

    private String url;

    private String signature;
}
