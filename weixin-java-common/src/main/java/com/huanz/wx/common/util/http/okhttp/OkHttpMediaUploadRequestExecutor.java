package com.huanz.wx.common.util.http.okhttp;

import com.huanz.wx.common.bean.WxError;
import com.huanz.wx.common.bean.WxMediaResult;
import com.huanz.wx.common.exception.WxErrorException;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.huanz.wx.common.util.http.MediaUploadRequestExecutor;
import com.huanz.wx.common.util.http.RequestHttp;

import java.io.File;
import java.io.IOException;

/**
 * @author ecoolper
 */
public class OkHttpMediaUploadRequestExecutor extends MediaUploadRequestExecutor<OkHttpClient, OkHttpProxyInfo> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public OkHttpMediaUploadRequestExecutor(RequestHttp requestHttp) {
        super(requestHttp);
    }

    @Override
    public WxMediaResult execute(String uri, File file) throws WxErrorException, IOException {
        logger.debug("OkHttpMediaUploadRequestExecutor is running");
        // 得到httpClient
        OkHttpClient client = requestHttp.getRequestHttpClient();

        RequestBody body = new MultipartBody.Builder()
                .setType(MediaType.parse("multipart/form-data"))
                .addFormDataPart("media",
                        file.getName(),
                        RequestBody.create(MediaType.parse("application/octet-stream"), file))
                .build();
        Request request = new Request.Builder().url(uri).post(body).build();

        Response response = client.newCall(request).execute();
        String responseContent = response.body().string();
        WxError error = WxError.fromJson(responseContent);
        if (error.getErrorCode() != 0) {
            throw new WxErrorException(error);
        }
        return WxMediaResult.fromJson(responseContent);
    }

}
