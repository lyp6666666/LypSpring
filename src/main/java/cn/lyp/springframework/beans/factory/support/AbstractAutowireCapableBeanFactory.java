package cn.lyp.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.lyp.springframework.beans.BeansException;
import cn.lyp.springframework.beans.PropertyValue;
import cn.lyp.springframework.beans.PropertyValues;
import cn.lyp.springframework.beans.factory.config.BeanDefinition;
import cn.lyp.springframework.beans.factory.config.BeanReference;

import java.io.ObjectStreamClass;
import java.lang.reflect.Constructor;

/**
 * @Author: 53256
 * @Date: 2025/4/30 11:33
 * @Description: 实现具体创建逻辑,负责实现创建 bean 的具体逻辑
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    //用于定义对象的实例化策略：使用反射 or 使用 Cglib 动态代理(默认Cglib)
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        // 加入单例缓存池
        addSingleton(beanName, bean);
        return bean;
    }


    protected Object createBeanInstance(BeanDefinition beanDefinition,String beanName , Object[] args){

        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        //获取并遍历所有构造函数
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            //根据传入的参数个数选择匹配的构造函数
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);

    }


    /**
     * Bean 属性填充
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }




    private InstantiationStrategy getInstantiationStrategy() {
        return this.instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }


}
