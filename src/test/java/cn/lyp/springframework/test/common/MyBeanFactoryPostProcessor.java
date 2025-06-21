package cn.lyp.springframework.test.common;


import cn.lyp.springframework.beans.BeansException;
import cn.lyp.springframework.beans.PropertyValue;
import cn.lyp.springframework.beans.PropertyValues;
import cn.lyp.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.lyp.springframework.beans.factory.config.BeanDefinition;
import cn.lyp.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
