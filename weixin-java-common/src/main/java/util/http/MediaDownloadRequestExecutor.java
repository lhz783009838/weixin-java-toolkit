package util.http;

import util.http.apache.ApacheMediaDownloadRequestExecutor;
import util.http.jodd.JoddHttpMediaDownloadRequestExecutor;
import util.http.okhttp.OkHttpMediaDownloadRequestExecutor;

import java.io.File;

/**
 * 流媒体下载客户端
 *
 * @author linhuanzhen
 */
public abstract class MediaDownloadRequestExecutor<H, P> implements RequestExecutor<File, String> {

    protected RequestHttp<H, P> requestHttp;

    protected File tmpDirFile;

    public MediaDownloadRequestExecutor(RequestHttp<H, P> requestHttp, File tmpDirFile) {
        this.requestHttp = requestHttp;
        this.tmpDirFile = tmpDirFile;
    }

    public static RequestExecutor<File, String> create(RequestHttp requestHttp, File file) {
        switch (requestHttp.getHttpClientType()) {
            case OK_HTTP:
                return new OkHttpMediaDownloadRequestExecutor(requestHttp, file);
            case JODD_HTTP:
                return new JoddHttpMediaDownloadRequestExecutor(requestHttp, file);
            case APACHE_HTTP:
                return new ApacheMediaDownloadRequestExecutor(requestHttp, file);
            default:
                return null;
        }
    }
}
