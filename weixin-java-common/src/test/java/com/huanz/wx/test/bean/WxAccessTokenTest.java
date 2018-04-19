package com.huanz.wx.test.bean;

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
}
