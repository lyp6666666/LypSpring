package cn.lyp.springframework.context.event;

import cn.lyp.springframework.beans.factory.BeanFactory;
import cn.lyp.springframework.context.ApplicationEvent;
import cn.lyp.springframework.context.ApplicationListener;

/**
 * @Author: LypCoding
 * @Date: 2025/6/25 9:39
 * @Description:
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory){
        setBeanFactory(beanFactory);
    }


    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
