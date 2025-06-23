package cn.lyp.springframework.beans.factory.support;

import cn.lyp.springframework.beans.BeansException;
import cn.lyp.springframework.beans.factory.config.BeanDefinition;
import cn.lyp.springframework.beans.factory.config.BeanPostProcessor;
import cn.lyp.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.lyp.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: 53256
 * @Date: 2025/4/30 11:33
 * @Description: 统一模板逻辑（模板方法模式）----核心模板调度者
 * 继承了DefaultSingletonBeanRegistry，也就具备了单例注册类方法。
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {


    /** ClassLoader to resolve bean class names with, if necessary */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

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


    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }


    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }


    public ClassLoader getBeanClassLoader(){
        return this.beanClassLoader;
    }
}
