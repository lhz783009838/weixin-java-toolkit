package com.huanz.wx.common.component;

/**
 * 消息重复检查器
 * 微信服务器在5s内收不到响应会断线连接，并重新发起请求，总共重试3次
 *
 * @author linhuanzhen
 */
public interface WxMessageDuplicateChecker {

    /**
     * 判断消息是否重复
     * 普通消息：关于重试的消息排重，推荐使用msgid排重。<a href="http://mp.weixin.qq.com/wiki/10/79502792eef98d6e0c6e1739da387346.html">文档参考</a>
     * 普通消息：关于重试的消息排重，推荐使用msgid排重。<a href="http://mp.weixin.qq.com/wiki/10/79502792eef98d6e0c6e1739da387346.html">文档参考</a>。
     * 事件消息：关于重试的消息排重，推荐使用FromUserName + CreateTime 排重。<a href="http://mp.weixin.qq.com/wiki/2/5baf56ce4947d35003b86a9805634b1e.html">文档参考</a>
     *
     * 企业号的排重方式
     * 官方文档完全没有写，参照公众号的方式排重。
     * 或者可以采取更简单的方式，如果有MsgId就用MsgId排重，如果没有就用FromUserName+CreateTime排重
     *
     * @param messageId messageId
     * @return true 重复消息
     */
    boolean isDuplicate(String messageId);
}
