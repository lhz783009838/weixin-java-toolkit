package com.huanz.wx.common.session;

import java.util.Enumeration;

/**
 * session通用接口
 *
 * @author linhuanzhen
 */
public interface WxSession {

    Object getAttribute(String name);

    Enumeration<String> getAttributeNames();

    void setAttribute(String name, Object value);

    void removeAttribute(String name);

    void invalidate();

}
