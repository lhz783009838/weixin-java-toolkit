package com.huanz.wx.test.bean;

import com.alibaba.fastjson.JSONObject;
import com.huanz.wx.common.bean.WxAccessToken;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class WxAccessTokenTest {

    public void testToken(){
        String response = "{\"access_token\":\"kMK77MEKL6HQ9tCAm4EJdrYCNrnLqLpIV\",\"expires_in\":\"7200\"}";
        WxAccessToken accessToken = WxAccessToken.fromJson(response);
        Assert.assertEquals(accessToken.getAccessToken(),"kMK77MEKL6HQ9tCAm4EJdrYCNrnLqLpIV");
        Assert.assertTrue(accessToken.getExpiresIn() == 7200);
    }

    public static class Aaa {
        private String a;
        private boolean b;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public boolean isB() {
            return b;
        }

        public void setB(boolean b) {
            this.b = b;
        }

        public static Aaa fromJson(String json){
            return JSONObject.toJavaObject(JSONObject.parseObject(json), Aaa.class);
        }
    }

    public void testAaa(){
        final String json = "{\"a\":\"a\",\"b\":0}";
        Aaa a = Aaa.fromJson(json);
    }
}
