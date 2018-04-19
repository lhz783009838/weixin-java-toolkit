package com.huanz.wx.mp.bean.result;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 公众号当前使用的自动回复规则
 *
 * @author linhuanzhen
 */
@Data
@ToString
public class WxMpCurrentAutoReplyInfo implements Serializable {

    private static final long serialVersionUID = 3004233576619167544L;

    /** 关注后自动回复是否开启，0代表未开启，1代表开启 **/
    @JSONField(name = "is_add_friend_reply_open")
    private boolean isAddFriendReplyOpen;

    /** 消息自动回复是否开启，0代表未开启，1代表开启 **/
    @JSONField(name = "is_autoreply_open")
    private boolean isAutoReplyOpen;

    /** 关注后自动回复的信息 **/
    @JSONField(name = "add_friend_autoreply_info")
    private AutoReplyInfo addFriendAutoReplyInfo;

    /** 消息自动回复的信息 **/
    @JSONField(name = "message_default_autoreply_info")
    private DefaultAutoReplyInfo messageDefaultAutoReplyInfo;

    /** 关键词自动回复的信息 **/
    @JSONField(name = "keyword_autoreply_info")
    private KeywordAutoReplyInfo keywordAutoReplyInfo;


    @Data
    @ToString
    public static class AutoReplyInfo implements Serializable {

        private static final long serialVersionUID = -4127203484665458441L;

        /** 自动回复的类型。关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、视频（video），关键词自动回复则还多了图文消息（news） **/
        private String type;

        /** 对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID **/
        private String content;
    }

    @Data
    @ToString
    public static class DefaultAutoReplyInfo implements Serializable {

        private static final long serialVersionUID = -1188164785429813584L;

        /** **/
        private String type;

        /** **/
        private String content;
    }

    @Data
    @ToString
    public static class KeywordAutoReplyInfo implements Serializable {

        private static final long serialVersionUID = -411810174444029202L;

        /** 自动回复规则 **/
        private List<AutoReplyRule> list;

    }

    @Data
    @ToString
    public static class AutoReplyRule implements Serializable {

        private static final long serialVersionUID = -1446445351072213685L;

        /** 规则名称 **/
        @JSONField(name = "rule_name")
        private String ruleName;

        /** 创建时间 **/
        @JSONField(name = "create_time", format = "yyyy-MM-dd HH:mm:ss")
        private Date createTime;

        /** 回复模式，reply_all代表全部回复，random_one代表随机回复其中一条 **/
        @JSONField(name = "reply_all")
        public String replyAll;

        /** 匹配的关键词列表 **/
        @JSONField(name = "keyword_list_info")
        private List<KeywordInfo> keywordListInfo;

        /** **/
        @JSONField(name = "reply_list_info")
        private List<ReplyInfo> replyListInfo;
    }

    @Data
    @ToString
    public static class KeywordInfo implements Serializable {

        private static final long serialVersionUID = -5930009269601008915L;

        /** **/
        private String type;

        /** 匹配模式，contain代表消息中含有该关键词即可，equal表示消息内容必须和关键词严格相同 **/
        @JSONField(name = "match_mode")
        private String matchMode;

        /** **/
        private String content;

    }

    @Data
    @ToString
    public static class ReplyInfo implements Serializable {

        private static final long serialVersionUID = -9214271956766567312L;

        /** **/
        private String type;

        /** **/
        private String content;

        /** 图文消息的信息 **/
        @JSONField(name = "newsInfo")
        private List<NewsInfo> newsInfo;
    }

    @Data
    @ToString
    public static class NewsInfo implements Serializable {

        private static final long serialVersionUID = -1824291184968561192L;

        /** 图文消息的标题 **/
        private String title;

        /** 摘要 **/
        private String digest;

        /** 作者 **/
        private String author;

        /** 是否显示封面，0为不显示，1为显示 **/
        @JSONField(name = "show_cover")
        private boolean showCover;

        /** 封面图片的URL **/
        @JSONField(name = "cover_url")
        private String coverUrl;

        /** 正文的URL **/
        @JSONField(name = "content_url")
        private String contentUrl;

        /** 原文的URL，若置空则无查看原文入口 **/
        @JSONField(name = "source_url")
        private String sourceUrl;
    }


}
