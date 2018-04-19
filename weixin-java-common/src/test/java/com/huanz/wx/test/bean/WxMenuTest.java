package com.huanz.wx.test.bean;

import com.huanz.wx.common.bean.WxMenu;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class WxMenuTest {

    @Test(dataProvider = "wxReturnMenu")
    public void menuTest(String json) {
        WxMenu menu = WxMenu.fromJson(json);
    }

    @DataProvider
    public Object[][] wxReturnMenu() {
        Object[][] res = menuJson();
        String json = "" + res[0][0];
        return new Object[][]{
                new Object[]{json}
        };
    }

    @DataProvider(name = "wxPushMenu")
    public Object[][] menuJson() {
        String json =
                "{"
                        + "\"button\":["
                        + "{"
                        + "\"type\":\"click\","
                        + "\"name\":\"今日歌曲\","
                        + "\"key\":\"V1001_TODAY_MUSIC\""
                        + "},"
                        + "{"
                        + "\"type\":\"click\","
                        + "\"name\":\"歌手简介\","
                        + "\"key\":\"V1001_TODAY_SINGER\""
                        + "},"
                        + "{"
                        + "\"name\":\"菜单\","
                        + "\"sub_button\":["
                        + "{"
                        + "\"type\":\"view\","
                        + "\"name\":\"搜索\","
                        + "\"url\":\"http://www.soso.com/\""
                        + "},"
                        + "{"
                        + "\"type\":\"view\","
                        + "\"name\":\"视频\","
                        + "\"url\":\"http://v.qq.com/\""
                        + "},"
                        + "{"
                        + "\"type\":\"click\","
                        + "\"name\":\"赞一下我们\","
                        + "\"key\":\"V1001_GOOD\""
                        + "}"
                        + "]"
                        + "}"
                        + "]"
                        + "}";
        return new Object[][]{
                new Object[]{json}
        };
    }
}
