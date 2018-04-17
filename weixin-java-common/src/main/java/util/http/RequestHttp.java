package util.http;

/**
 * @param <H> 执行客户端
 * @param <P> 代理
 * @author linhuanzhen
 */
public interface RequestHttp<H, P> {

    /**
     * 获取当前 httpClient
     *
     * @return H
     */
    H getRequestHttpClient();

    /**
     * 获取当前 requestProxy
     *
     * @return P
     */
    P getRequestHttpProxy();

    /**
     * 获取当前http客户端类型
     *
     * @return 三种类型: apache http , jodd http , ok http
     */
    HttpClientType getHttpClientType();
}
