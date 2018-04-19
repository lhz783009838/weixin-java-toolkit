package com.huanz.wx.common.session;

/**
 * session 管理器
 *
 * @author linhuanzhen
 */
public interface WxSessionManager {

    /**
     * 获取某个sessionId对应的session,如果sessionId没有对应的session，则新建一个并返回。
     */
    WxSession getSession(String sessionId);

    /**
     * 获取某个sessionId对应的session,如果sessionId没有对应的session，若create为true则新建一个，否则返回null。
     */
    WxSession getSession(String sessionId, boolean create);


}
