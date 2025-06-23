package cn.lyp.springframework.context.support;

import cn.lyp.springframework.beans.BeansException;
import cn.lyp.springframework.beans.factory.config.BeanPostProcessor;
import cn.lyp.springframework.context.ApplicationContext;
import cn.lyp.springframework.context.ApplicationContextAware;

/**
 * @Author: LypCoding
 * @Date: 2025/6/23 17:05
 * @Description: 包装处理器
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ApplicationContextAware){
            ((ApplicationContextAware)bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
