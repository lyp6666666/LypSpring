package cn.lyp.springframework.context;

/**
 * @Author: LypCoding
 * @Date: 2025/6/25 9:30
 * @Description: 事件发布者的定义与实现
 */
public interface ApplicationEventPublisher {


    /**
     *通知所有在此应用程序中注册的侦听器某个应用程序
     *活动。事件可以是框架事件（如RequestHandledEvent）
     *或特定于应用程序的事件。
     *@param事件要发布的事件
     */
    void publishEvent(ApplicationEvent event);

}
