package util.http;

import util.http.apache.ApacheHttpClientSimpleGetRequestExecutor;
import util.http.jodd.JoddHttpSimpleGetRequestExecutor;

/**
 * 简单的Get请求，参数类型为String，返回值类型为String
 *
 * @author linhuanzhen
 */
public abstract class SimpleGetRequestExecutor<H, P> implements RequestExecutor<String, String> {

    protected RequestHttp<H, P> requestHttp;

    public SimpleGetRequestExecutor(RequestHttp<H, P> requestHttp) {
        this.requestHttp = requestHttp;
    }

    /**
     * 创建http客户端
     *
     * @param httpRequest
     * @return
     */
    public static RequestExecutor<String, String> create(RequestHttp httpRequest) {
        switch (httpRequest.getHttpClientType()) {
            case OK_HTTP:
                return new ApacheHttpClientSimpleGetRequestExecutor(httpRequest);
            case JODD_HTTP:
                return new JoddHttpSimpleGetRequestExecutor(httpRequest);
            case APACHE_HTTP:
                return new ApacheHttpClientSimpleGetRequestExecutor(httpRequest);
            default:
                return null;
        }
    }
}
