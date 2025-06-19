package cn.lyp.springframework.beans.factory.support;

import cn.lyp.springframework.beans.BeansException;
import cn.lyp.springframework.beans.factory.BeanFactory;
import cn.lyp.springframework.beans.factory.config.BeanDefinition;


/**
 * @Author: 53256
 * @Date: 2025/4/30 11:33
 * @Description: 统一模板逻辑（模板方法模式）----核心模板调度者
 * 继承了DefaultSingletonBeanRegistry，也就具备了单例注册类方法。
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException{
        return getBean(name, (Object) null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {

        return doGetBean(name,args);
    }

    @Override
    public <T> T getBean(String name , Class<T> requiredType )throws BeansException{
        return (T) getBean(name);
    }


    protected <T> T doGetBean(final String name , final Object[] args){
        Object bean = getSingleton(name);
        if(bean != null){
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name,beanDefinition,args);
    }




    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanBean , BeanDefinition beanDefinition,Object[] args) throws BeansException;



}
