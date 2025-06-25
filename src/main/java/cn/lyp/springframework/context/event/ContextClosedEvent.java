package cn.lyp.springframework.context.event;

/**
 * @Author: LypCoding
 * @Date: 2025/6/25 9:16
 * @Description:
 */
public class ContextClosedEvent extends ApplicationContextEvent{

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }


}
