package com.huanz.wx.mp.api;

import com.huanz.wx.common.bean.WxJsApiSignature;
import com.huanz.wx.common.exception.WxErrorException;
import com.huanz.wx.common.util.http.RequestExecutor;
import com.huanz.wx.common.util.http.RequestHttp;
import com.huanz.wx.mp.bean.WxMpSemanticQuery;
import com.huanz.wx.mp.bean.WxMpSemanticQueryResult;
import com.huanz.wx.mp.bean.result.WxMpCurrentAutoReplyInfo;
import com.huanz.wx.mp.bean.result.WxMpOAuth2AccessToken;
import com.huanz.wx.mp.bean.result.WxMpUser;

/**
 * 微信公众号通用接口
 *
 * @author linhuanzhen
 */
public interface WxMpService {

    /**
     * 获取access_token
     */
    String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    /**
     * 获得jsapi_ticket
     */
    String GET_JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi";
    /**
     * 长链接转短链接接口
     */
    String SHORTURL_API_URL = "https://api.weixin.qq.com/cgi-bin/shorturl";
    /**
     * 语义查询接口
     */
    String SEMANTIC_SEMPROXY_SEARCH_URL = "https://api.weixin.qq.com/semantic/semproxy/search";
    /**
     * 用code换取oauth2的access token
     */
    String OAUTH2_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
    /**
     * 刷新oauth2的access token
     */
    String OAUTH2_REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s";
    /**
     * 用oauth2获取用户信息
     */
    String OAUTH2_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=%s";
    /**
     * 验证oauth2的access token是否有效
     */
    String OAUTH2_VALIDATE_TOKEN_URL = "https://api.weixin.qq.com/sns/auth?access_token=%s&openid=%s";
    /**
     * 获取微信服务器IP地址
     */
    String GET_CALLBACK_IP_URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip";
    /**
     * 第三方使用网站应用授权登录的url
     */
    String QRCONNECT_URL = "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect";
    /**
     * oauth2授权的url连接
     */
    String CONNECT_OAUTH2_AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect";
    /**
     * 获取公众号的自动回复规则
     */
    String GET_CURRENT_AUTOREPLY_INFO_URL = "https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info";
    /**
     * 公众号调用或第三方平台帮公众号调用对公众号的所有api调用（包括第三方帮其调用）次数进行清零
     */
    String CLEAR_QUOTA_URL = "https://api.weixin.qq.com/cgi-bin/clear_quota";

    /**
     * 初始化http对象
     */
    void initHttp();

    /**
     * 获取RequestHttp对象
     *
     * @return RequestHttp
     */
    RequestHttp getRequestHttp();

    /**
     * 验证信息是否来自微信服务器
     *
     * @param timeStamp 时间戳
     * @param nonce     提示
     * @param signature 签名文本
     * @return true 是 false 否
     */
    boolean checkSignature(String timeStamp, String nonce, String signature);

    /**
     * 获取 AccessToken
     *
     * @return 公众号 access_token
     * @throws WxErrorException exception
     */
    String getAccessToken() throws WxErrorException;

    /**
     * 刷新并获取 AccessToken
     * 本方法线程安全且在多线程同时执行时只会刷新一次，避免超出微信每日刷新token限制
     * 是唯一token过期时调用接口
     *
     * @param forceRefresh 是否强制刷新
     * @return 公众号 access_token
     * @throws WxErrorException exception
     */
    String getAccessToken(boolean forceRefresh) throws WxErrorException;

    /**
     * 获取 jsApiTicket
     *
     * @return 微信 jsapi_ticket
     * @throws WxErrorException exception
     */
    String getJsApiTicket() throws WxErrorException;

    /**
     * 刷新并获取 JsApiTicker
     *
     * @param forceRefresh 是否强制刷新
     * @return 微信 jsapi_ticker
     * @throws WxErrorException exception
     */
    String getJsApiTicket(boolean forceRefresh) throws WxErrorException;

    /**
     * 创建调用JsApi时所需要的签名
     *
     * @param url 请求对应 url
     * @return 签名信息
     * @throws WxErrorException exception
     */
    WxJsApiSignature createJsApiSignature(String url) throws WxErrorException;

    /**
     * 长链接转短连接接口
     * 主要用于太长的链接导致相应速度变慢，此时可通过此接口将链接变短,
     * 开发者用于生成二维码的原链接（商品、支付二维码等）太长导致扫码速度和成功率下降，将原长链接通过此接口转成短链接再生成二维码将大大提升扫码速度和成功率。
     *
     * @param longUrl 长链接地址
     * @return 短链接地址
     * @throws WxErrorException exception
     */
    String shortUrl(String longUrl) throws WxErrorException;

    /**
     * 微信语义查询接口
     * 微信开放平台语义理解接口调用（http请求）简单方便，用户无需掌握语义理解及相关技术，只需根据自己的产品特点，选择相应的服务即可搭建一套智能语义服务。
     *
     * @param query 查询参数
     * @return 查询结果
     * @throws WxErrorException exception
     */
    WxMpSemanticQueryResult semanticQuery(WxMpSemanticQuery query) throws WxErrorException;

    /**
     * 构造第三方使用网站应用授权登录的url
     *
     * @param redirectUri 授权成功后重定向链接，使用明文url，无需加密，该方法会对url进行加密
     * @param scope       授权作用域，拥有多个作用域使用“,”隔开，网页授权当前仅使用“snsapi_login”
     * @param state       非必填，用于保持请求和回调的状态，授权请求后原样带回给第三方。该参数可用于防止csrf攻击（跨站请求伪造攻击），建议第三方带上该参数，可设置为简单的随机数加session进行校验
     * @return 授权url
     */
    String buildQrConnectUrl(String redirectUri, String scope, String state) throws WxErrorException;

    /**
     * 构造oauth2授权的url链接
     *
     * @param redirectUri 授权成功后重定向链接，使用明文url，无需加密，该方法会对url进行加密
     * @param scope       授权作用域，拥有多个作用域使用“,”隔开，网页授权当前仅使用“snsapi_login”
     * @param state       非必填，用于保持请求和回调的状态，授权请求后原样带回给第三方。该参数可用于防止csrf攻击（跨站请求伪造攻击），建议第三方带上该参数，可设置为简单的随机数加session进行校验
     * @return 授权url
     */
    String oauth2buildAuthorizationUrl(String redirectUri, String scope, String state) throws WxErrorException;

    /**
     * 通过code获取用户第三方授权信息
     *
     * @param code 授权码
     * @return 授权信息
     * @throws WxErrorException exception
     */
    WxMpOAuth2AccessToken oauth2getAccessToken(String code) throws WxErrorException;

    /**
     * 通过refreshToken刷新用户授权信息
     * refreshToken有效期为30天，过期后需要用户重新授权
     *
     * @param refreshToken 用户刷新 access_token
     * @return 刷新后的用户授权信息
     * @throws WxErrorException exception
     */
    WxMpOAuth2AccessToken oauth2refreshAccessToken(String refreshToken) throws WxErrorException;

    /**
     * 第三方获取用户资料
     *
     * @param auth2AccessToken 授权信息
     * @param lang             语言类型：zh_CN, zh_TW, en
     * @return 用户信息
     * @throws WxErrorException exception
     */
    WxMpUser oauth2getUserInfo(WxMpOAuth2AccessToken auth2AccessToken, String lang) throws WxErrorException;

    /**
     * 校验授权信息是否有效
     *
     * @param auth2AccessToken 授权信息
     * @return true 有效 false 无效
     * @throws WxErrorException exception
     */
    boolean oauth2validateAccessToken(WxMpOAuth2AccessToken auth2AccessToken) throws WxErrorException;

    /**
     * 获取微信服务器IP地址
     *
     * @return ip地址
     * @throws WxErrorException exception
     */
    String[] getCallbackIP() throws WxErrorException;

    /**
     * 获取公众号当前使用的自动回复规则，包括关注后自动回复、消息自动回复（60分钟内触发一次）、关键词自动回复。
     * 1、第三方平台开发者可以通过本接口，在旗下公众号将业务授权给你后，立即通过本接口检测公众号的自动回复配置，并通过接口再次给公众号设置好自动回复规则，以提升公众号运营者的业务体验。
     * 2、本接口仅能获取公众号在公众平台官网的自动回复功能中设置的自动回复规则，若公众号自行开发实现自动回复，或通过第三方平台开发者来实现，则无法获取。
     * 3、认证/未认证的服务号/订阅号，以及接口测试号，均拥有该接口权限。
     * 4、从第三方平台的公众号登录授权机制上来说，该接口从属于消息与菜单权限集。
     * 5、本接口中返回的图片/语音/视频为临时素材（临时素材每次获取都不同，3天内有效，通过素材管理-获取临时素材接口来获取这些素材），本接口返回的图文消息为永久素材素材（通过素材管理-获取永久素材接口来获取这些素材）。
     *
     * @return 自动回复规则
     * @throws Exception exception
     */
    WxMpCurrentAutoReplyInfo getCurrentAutoReplyInfo() throws Exception;

    /**
     * 公众号调用或第三方平台帮公众号调用对公众号的所有api调用（包括第三方帮其调用）次数进行清零：
     *
     * @param appId appId
     * @throws WxErrorException exception
     */
    void clearQuota(String appId) throws WxErrorException;

    /**
     * 默认的GET请求
     *
     * @param url        请求地址
     * @param queryParam 请求参数
     */
    String get(String url, String queryParam) throws WxErrorException;

    /**
     * 默认的POST请求
     *
     * @param url      请求地址
     * @param postData 表单参数json字符串
     */
    String post(String url, String postData) throws WxErrorException;

    /**
     * 默认的请求处理
     *
     * @param executor 请求处理器（http客户端）
     * @param url      请求地址
     * @param data     请求参数
     * @param <T>      返回值类型
     * @param <E>      参数类型
     * @return 微信响应结果
     * @throws WxErrorException exception
     */
    <T, E> T execute(RequestExecutor<T, E> executor, String url, E data) throws WxErrorException;

    /**
     * 设置微信服务端处理请求超时时间
     *
     * @param retrySleepMillions 超时时间（单位毫秒），默认1000ms
     * @throws WxErrorException exception
     */
    void setRetrySleepMillion(int retrySleepMillions);

    /**
     * 设置微信服务端请求超时最大重试次数
     *
     * @param maxRetryTimes 最大重试次数（单位次），默认5次
     */
    void setMaxRetryTimes(int maxRetryTimes);

    /**
     * 获取公众号全局配置信息
     *
     * @return 配置信息
     */
    WxMpConfigStorage getWxMpConfigStorage();

    /**
     * 设置公众号全局配置信息
     *
     * @param wxMpConfigStorage 配置信息
     */
    void setWxMpConfigStorage(WxMpConfigStorage wxMpConfigStorage);

    /**
     * 获取客服接口方法
     *
     * @return 客服接口
     */
    WxMpKefuService getKefuService();

    /**
     * 设置客服接口实现类
     *
     * @param wxMpKefuService 客服接口实现类
     */
    void setWxMpKefuService(WxMpKefuService wxMpKefuService);

    /**
     * 获取素材管理，媒体管理接口
     *
     * @return 素材管理，媒体管理接口
     */
    WxMpMaterialService getWxMpMaterialService();

    /**
     * 设置素材管理，媒体管理接口
     *
     * @param wxMpMaterialService 素材管理，媒体管理接口实现类
     */
    void setWxMpMaterialService(WxMpMaterialService wxMpMaterialService);

    /**
     * 获取公众号菜单操作接口
     *
     * @return 菜单操作接口
     */
    WxMpMenuService getWxMpMenuService();

    /**
     * 设置公众号菜单操作接口
     *
     * @param wxMpMenuService 公众号菜单操作接口实现类
     */
    void setWxMpMenuService(WxMpMenuService wxMpMenuService);

    /**
     * 获取用户操作接口
     *
     * @return 用户操作接口
     */
    WxMpUserService getWxMpUserService();

    /**
     * 设置用户操作接口
     *
     * @param wxMpUserService 用户操作接口实现类
     */
    void setWxMpUserService(WxMpUserService wxMpUserService);

    /**
     * 获取用户标签操作接口
     *
     * @return 用户标签接口
     */
    WxMpUserTagService getWxMpUserTagService();

    /**
     * 设置用户标签操作接口
     *
     * @param wxMpUserTagService 用户标签操作接口实现类
     */
    void setWxMpUserTagService(WxMpUserTagService wxMpUserTagService);

    /**
     * 获取二维码操作接口
     *
     * @return 二维码接口
     */
    WxMpQrcodeService getWxMpQrcodeService();

    /**
     * 设置二维码操作接口
     *
     * @param wxMpQrcodeService 二维码操作接口接口
     */
    void setWxMpQrcodeService(WxMpQrcodeService wxMpQrcodeService);

    /**
     * 获取卡券接口
     *
     * @return 卡券接口
     */
    WxMpCardService getWxMpCardService();

    /**
     * 设置卡券接口
     *
     * @param wxMpCardService 卡券接口实现类
     */
    void setWxMpCardService(WxMpCardService wxMpCardService);

    /**
     * 获取数据统计接口
     *
     * @return 数据统计接口
     */
    WxMpDataCubeService getWxMpDataCubeService();

    /**
     * 设置数据统计接口
     *
     * @param wxMpDataCubeService 数据统计接口实现类
     */
    void setWxMpDataCubeService(WxMpDataCubeService wxMpDataCubeService);

    /**
     * 获取用户黑名单接口
     *
     * @return 用户黑名单接口
     */
    WxMpUserBlacklistService getWxMpUserBlacklistService();

    /**
     * 设置用户黑名单接口
     *
     * @param wxMpUserBlacklistService 用户黑名单接口实现类
     */
    void setWxMpUserBlacklistService(WxMpUserBlacklistService wxMpUserBlacklistService);

    /**
     * 获取门店管理接口
     *
     * @return 门店管理接口
     */
    WxMpStoreService getWxMpStoreService();

    /**
     * 设置门店管理接口
     *
     * @param wxMpStoreService 门店管理接口实现类
     */
    void setWxMpStoreService(WxMpStoreService wxMpStoreService);

    /**
     * 获取模板消息接口
     *
     * @return 模板消息接口
     */
    WxMpTemplateMsgService getWxMpTemplateMsgService();

    /**
     * 设置模板消息接口
     *
     * @param wxMpTemplateMsgService 模板消息接口实现类
     */
    void setWxMpTemplateMsgService(WxMpTemplateMsgService wxMpTemplateMsgService);

    /**
     * 获取一次性订阅消息接口
     *
     * @return 一次性订阅消息接口
     */
    WxMpSubscribeMsgService getWxMpSubscribeMsgService();

    /**
     * 设置一次性订阅消息接口
     *
     * @param wxMpSubscribeMsgService 一次性订阅消息接口实现类
     */
    void setWxMpSubscribeMsgService(WxMpSubscribeMsgService wxMpSubscribeMsgService);

    /**
     * 获取硬件平台接口
     *
     * @return 硬件平台接口
     */
    WxMpDeviceService getWxMpDeviceService();

    /**
     * 设置硬件平台接口
     *
     * @param wxMpDeviceService 硬件平台接口实现类
     */
    void setWxMpDeviceService(WxMpDeviceService wxMpDeviceService);

    /**
     * 获取摇一摇周边接口
     *
     * @return 摇一摇周边接口
     */
    WxMpShakeService getWxMpShakeService();

    /**
     * 设置摇一摇周边接口
     *
     * @param wxMpShakeService 摇一摇周边接口实现类
     */
    void setWxMpShakeService(WxMpShakeService wxMpShakeService);

    /**
     * 获取会员卡接口
     *
     * @return 会员卡接口
     */
    WxMpMemberCardService getWxMpMemberCardService();

    /**
     * 设置会员卡接口
     *
     * @param wxMpMemberCardService 会员卡接口实现类
     */
    void setWxMpMemberCardService(WxMpMemberCardService wxMpMemberCardService);

    /**
     * 获取微信群发消息接口
     *
     * @return 微信群发消息接口
     */
    WxMpMassMessageService getWxMpMassMessageService();

    /**
     * 设置微信群发消息接口
     *
     * @param wxMpMassMessageService 微信群发消息接口实现类
     */
    void setWxMpMassMessageService(WxMpMassMessageService wxMpMassMessageService);
}
