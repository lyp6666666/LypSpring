package cn.lyp.springframework.context;

import java.util.EventObject;

/**
 * @Author: LypCoding
 * @Date: 2025/6/25 9:07
 * @Description:
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source){
        super(source);
    }

}
