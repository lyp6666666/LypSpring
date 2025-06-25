package cn.lyp.springframework.context.event;

import cn.lyp.springframework.context.ApplicationContext;
import cn.lyp.springframework.context.ApplicationEvent;

/**
 * @Author: LypCoding
 * @Date: 2025/6/25 9:09
 * @Description:
 */
public class ApplicationContextEvent extends ApplicationEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * Get the <code>ApplicationContext</code> that the event was raised for.
     */
    public final ApplicationContext getApplicationContext(){
        return (ApplicationContext) getSource();
    }
}
