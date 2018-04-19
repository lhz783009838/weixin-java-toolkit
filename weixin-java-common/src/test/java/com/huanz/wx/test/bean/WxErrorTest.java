package com.huanz.wx.test.bean;

import com.huanz.wx.common.bean.WxError;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class WxErrorTest {

    public void errorBeanTest() {
        final String rsp = "{\"error_code\":\"400001\",\"error_msg\":\"fuck you\"}";
        WxError error = WxError.fromJson(rsp);
        Assert.assertTrue(error.getErrorCode() == 400001);
        Assert.assertEquals(error.getErrorMsg(),"fuck you");
    }
}
