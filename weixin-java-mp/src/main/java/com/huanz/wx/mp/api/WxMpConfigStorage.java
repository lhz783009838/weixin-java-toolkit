package com.huanz.wx.mp.api;

import com.huanz.wx.common.util.http.apache.ApacheHttpClientBuilder;

import java.io.File;
import java.util.concurrent.locks.Lock;

/**
 * 微信公众号全局配置（储存）接口
 *
 * @author linhuanzhen
 */
public interface WxMpConfigStorage {

    String getAccessToken();

    Lock getAccessTokenLock();

    boolean isAccessTokenExpired();

    void expireAccessToken();

    void updateAccessToken(String accessToken, int expiresInSeconds);

    String getJsApiTicketLock();

    boolean isJsApiTicketExpired();

    void expireJsApiTicket();

    void updateJsApiTicket(String jsapiTicket, int expiresInSeconds);

    String getCardApiTicket();

    Lock getCardApiTicketLock();

    boolean ISCardApiTicketExpired();

    void expireCardApiTicket();

    void updateCardApiTicket(String cardApiTicket, int expiresInSeconds);

    String getAppId();

    String getSecret();

    String getToken();

    String getAesKey();

    String getTemplateId();

    long getExpiresTime();

    String getOauth2redirectUri();

    String getHttpProxyHost();

    int getHttpProxyPort();

    String getHttpProxyUsername();

    String getHttpProxyPassword();

    File getTmpDirFile();

    ApacheHttpClientBuilder getApacheHttpClientBuilder();

    boolean autoRefreshToken();
}
