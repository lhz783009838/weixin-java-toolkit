package com.huanz.wx.test.component;

import com.huanz.wx.common.component.WxMessageInMemoryDuplicateChecker;
import org.testng.Converter;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Test
public class WxMessageInMemoryDuplicateCheckerTest {

    // 存活时间 2秒，检查时间 1秒
    private WxMessageInMemoryDuplicateChecker checker = new WxMessageInMemoryDuplicateChecker(2000L, 1000L);

    public void duplicateCheckerTest() throws Exception {
        // 首次检查
        Long[] msgIds = {1L, 2L, 3L, 4L, 5L, 6L, 7L};
        checker(msgIds);
        System.out.println("============第一检查结束============");
        // 间隔 1秒 后再次检查
        TimeUnit.SECONDS.sleep(1);
        checker(msgIds);
        System.out.println("============第二检查结束============");
        // 再次间隔1.5秒
        TimeUnit.MILLISECONDS.sleep(2000L);
        checker(msgIds);
        System.out.println("============第仨检查结束============");
    }

    private void checker(Long[] msgIds) {
        for (Long msgId : msgIds) {
            boolean duplicate = checker.isDuplicate(String.valueOf(msgId));
            System.out.println("检查结果： " + duplicate);
        }
    }
}
