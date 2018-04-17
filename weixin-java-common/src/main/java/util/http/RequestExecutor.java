package util.http;

import exception.WxErrorException;

import java.io.IOException;

/**
 * http请求执行器
 *
 * @param <T> 返回类型
 * @param <E> 参数类型
 * @author linhuanzhen
 */
public interface RequestExecutor<T, E> {

    /**
     * 执行通用接口
     *
     * @param uri  请求路径
     * @param data 参数
     * @return 返回结果
     * @throws WxErrorException WxErrorException
     * @throws IOException      IOException
     */
    T execute(String uri, E data) throws WxErrorException, IOException;
}
