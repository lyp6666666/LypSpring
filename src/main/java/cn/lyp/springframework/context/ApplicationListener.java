package cn.lyp.springframework.context;

import java.util.EventListener;

/**
 * @Author: LypCoding
 * @Date: 2025/6/25 9:24
 * @Description:
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);

}
