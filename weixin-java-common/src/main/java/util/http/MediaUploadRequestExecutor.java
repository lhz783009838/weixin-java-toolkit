package util.http;

import bean.WxMediaResult;
import util.http.apache.ApacheMediaUploadRequestExecutor;
import util.http.jodd.JoddHttpMediaUploadRequestExecutor;
import util.http.okhttp.OkHttpMediaUploadRequestExecutor;

import java.io.File;

/**
 * 流媒体上传客户端
 *
 * @author linhauznehn
 */
public abstract class MediaUploadRequestExecutor<H, P> implements RequestExecutor<WxMediaResult, File> {

    protected RequestHttp<H, P> requestHttp;

    public MediaUploadRequestExecutor(RequestHttp<H, P> requestHttp) {
        this.requestHttp = requestHttp;
    }

    /**
     * 创建多上传下载客户端
     *
     * @param requestHttp
     * @return
     */
    public static RequestExecutor<WxMediaResult, File> create(RequestHttp requestHttp) {
        switch (requestHttp.getHttpClientType()) {
            case OK_HTTP:
                return new OkHttpMediaUploadRequestExecutor(requestHttp);
            case JODD_HTTP:
                return new JoddHttpMediaUploadRequestExecutor(requestHttp);
            case APACHE_HTTP:
                return new ApacheMediaUploadRequestExecutor(requestHttp);
            default:
                return null;
        }
    }

}
