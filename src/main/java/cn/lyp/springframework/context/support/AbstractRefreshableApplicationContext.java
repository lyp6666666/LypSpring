package cn.lyp.springframework.context.support;

import cn.lyp.springframework.beans.BeansException;
import cn.lyp.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.lyp.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author: LypCoding
 * @Date: 2025/6/19 18:59
 * @Description: 获取Bean工厂和加载资源
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;


    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinition(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory(){
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinition(DefaultListableBeanFactory beanFactory);


    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
