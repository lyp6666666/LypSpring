package cn.lyp.springframework.beans.factory.support;

import cn.lyp.springframework.beans.factory.config.BeanDefinition;

/**
 * @Author: 53256
 * @Date: 2025/4/30 11:34
 * @Description:
 */
public interface BeanDefinitionRegistry {

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
