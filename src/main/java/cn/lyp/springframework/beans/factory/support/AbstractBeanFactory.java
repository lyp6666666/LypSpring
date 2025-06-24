package cn.lyp.springframework.beans.factory.support;

import cn.lyp.springframework.beans.BeansException;
import cn.lyp.springframework.beans.factory.FactoryBean;
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
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {


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


    protected <T> T doGetBean(final String name, final Object[] args) {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            // 如果是 FactoryBean，则需要调用 FactoryBean#getObject
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object object = getCachedObjectForFactoryBean(beanName);

        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }

        return object;
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName){
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
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
