package com.huanz.wx.common.util.http.jodd;

import com.huanz.wx.common.bean.WxError;
import com.huanz.wx.common.bean.WxMediaResult;
import com.huanz.wx.common.exception.WxErrorException;
import jodd.http.HttpConnectionProvider;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.http.ProxyInfo;
import jodd.util.StringPool;
import com.huanz.wx.common.util.http.MediaUploadRequestExecutor;
import com.huanz.wx.common.util.http.RequestHttp;


import java.io.File;
import java.io.IOException;

/**
 * @author ecoolper
 */
public class JoddHttpMediaUploadRequestExecutor extends MediaUploadRequestExecutor<HttpConnectionProvider, ProxyInfo> {

    public JoddHttpMediaUploadRequestExecutor(RequestHttp requestHttp) {
        super(requestHttp);
    }

    @Override
    public WxMediaResult execute(String uri, File file) throws WxErrorException, IOException {
        HttpRequest request = HttpRequest.post(uri);
        if (requestHttp.getRequestHttpProxy() != null) {
            requestHttp.getRequestHttpClient().useProxy(requestHttp.getRequestHttpProxy());
        }
        request.withConnectionProvider(requestHttp.getRequestHttpClient());
        request.form("media", file);
        HttpResponse response = request.send();
        response.charset(StringPool.UTF_8);

        String responseContent = response.bodyText();
        WxError error = WxError.fromJson(responseContent);
        if (error.getErrorCode() != 0) {
            throw new WxErrorException(error);
        }
        return WxMediaResult.fromJson(responseContent);
    }
}
