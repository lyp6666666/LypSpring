package cn.lyp.springframework.context.event;

import cn.lyp.springframework.context.ApplicationEvent;
import cn.lyp.springframework.context.ApplicationListener;

/**
 * @Author: LypCoding
 * @Date: 2025/6/25 9:22
 * @Description: 事件广播器
 * 在事件广播器中定义了添加监听和删除监听的方法以及一个广播事件的方法 multicastEvent 最终推送时间消息也会经过这个接口方法来处理谁该接收事件。
 */
public interface ApplicationEventMulticaster {


    /**
     * Add a listener to be notified of all events.
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners.
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);


}
