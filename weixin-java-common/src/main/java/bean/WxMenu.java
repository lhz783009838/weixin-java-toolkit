package bean;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.asm.Type;
import lombok.Data;
import lombok.extern.java.Log;
import org.apache.commons.lang3.CharSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author linhuanzhen
 */
@Data
public class WxMenu implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(WxMenu.class);

    private static final long serialVersionUID = 6104396208285346643L;

    private List<WxMenuButton> buttons = new ArrayList<>();

    private WxMenuRule matchRule;

    public static WxMenu fromJson(String json) {
        return JSONObject.toJavaObject(JSONObject.parseObject(json), WxMenu.class);
    }

    public static WxMenu fromJson(InputStream is) {
        // todo 流转对象，暂时没实现
        return null;
    }

    public String toJson() {
        return JSONObject.toJSONString(this);
    }
}
