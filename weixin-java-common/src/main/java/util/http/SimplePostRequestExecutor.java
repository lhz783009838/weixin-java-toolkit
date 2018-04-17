package util.http;

import util.http.apache.ApacheSimplePostRequestExecutor;
import util.http.jodd.JoddHttpSimplePostRequestExecutor;
import util.http.okhttp.OkHttpSimplePostRequestExecutor;

/**
 * 简单的post请求
 *
 * @author linhuanzhen
 */
public abstract class SimplePostRequestExecutor<H, P> implements RequestExecutor<String, String> {

    protected RequestHttp<H, P> requestHttp;

    public SimplePostRequestExecutor(RequestHttp<H, P> requestHttp) {
        this.requestHttp = requestHttp;
    }

    public static RequestExecutor<String, String> create(RequestHttp requestHttp) {
        switch (requestHttp.getHttpClientType()) {
            case OK_HTTP:
                return new OkHttpSimplePostRequestExecutor(requestHttp);
            case JODD_HTTP:
                return new JoddHttpSimplePostRequestExecutor(requestHttp);
            case APACHE_HTTP:
                return new ApacheSimplePostRequestExecutor(requestHttp);
            default:
                return null;
        }
    }
}
