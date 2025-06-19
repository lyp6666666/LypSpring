package cn.lyp.springframework.beans.factory.support;

import cn.lyp.springframework.core.io.DefaultResourceLoader;
import cn.lyp.springframework.core.io.ResourceLoader;

/**
 * @Author: LypCoding
 * @Date: 2025/6/19 13:39
 * @Description: Bean定义抽象类实现
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry){
        this(registry,new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry(){
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader(){
        return resourceLoader;
    }


}
