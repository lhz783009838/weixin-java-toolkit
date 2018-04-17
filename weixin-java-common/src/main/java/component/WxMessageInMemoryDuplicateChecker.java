package component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 消息重复检查器
 * 将每个消息id保存在内存中，每个5秒清理已经过期的消息id，每个消息的过期时间是15秒
 *
 * @author linhuanzhen
 */
public class WxMessageInMemoryDuplicateChecker implements WxMessageDuplicateChecker {

    /**
     * 一个消息id在内存的过期时间是15秒
     **/
    private final Long timeToLive;

    /**
     * 每隔多少周期检查消息ID是否过期
     **/
    private final Long ClearPeriod;

    /**
     * 消息id（消息时间戳）存放Map
     **/
    private final ConcurrentHashMap<String, Long> msgIdTimestamp = new ConcurrentHashMap<>();

    /**
     * 后台清理线程是否已经开始
     **/
    private final AtomicBoolean backgroundProcessStarted = new AtomicBoolean(false);

    /**
     * 默认配置
     **/
    public WxMessageInMemoryDuplicateChecker() {
        this.timeToLive = 15 * 1000L;
        ClearPeriod = 5 * 1000L;
    }

    /**
     * 自定义配置
     *
     * @param timeToLive  过期时间
     * @param clearPeriod 检查时间
     */
    public WxMessageInMemoryDuplicateChecker(Long timeToLive, Long clearPeriod) {
        this.timeToLive = timeToLive;
        ClearPeriod = clearPeriod;
    }

    /**
     * 定时检查内存中的消息是否过期
     */
    private void checkedBackGroundProcessStarted() {
        if (this.backgroundProcessStarted.getAndSet(true)) {
            return;
        }
        Thread removeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        // 默认间隔5秒查询一次
                        Thread.sleep(WxMessageInMemoryDuplicateChecker.this.ClearPeriod);
                        Long now = System.currentTimeMillis();
                        for (Map.Entry<String, Long> entry : WxMessageInMemoryDuplicateChecker.this.msgIdTimestamp.entrySet()) {
                            // 如果当前时间减去保存时的时间 > 15秒，删除内存中的msgId
                            if (now - entry.getValue() > WxMessageInMemoryDuplicateChecker.this.timeToLive) {
                                WxMessageInMemoryDuplicateChecker.this.msgIdTimestamp.entrySet().remove(entry);
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        removeThread.setDaemon(true);
        removeThread.start();
    }

    @Override
    public boolean isDuplicate(String messageId) {
        if (null == messageId) {
            return false;
        }
        checkedBackGroundProcessStarted();
        // 如果内存中messageId匹配某个键，说明该消息已存在，将当前时间关联到该键，并返回当前时间
        Long timestamp = this.msgIdTimestamp.putIfAbsent(messageId, System.currentTimeMillis());
        return null != timestamp;
    }
}
