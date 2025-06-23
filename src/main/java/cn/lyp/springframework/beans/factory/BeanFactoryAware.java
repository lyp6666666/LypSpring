package cn.lyp.springframework.beans.factory;

import cn.lyp.springframework.beans.BeansException;

/**
 * @Author: LypCoding
 * @Date: 2025/6/23 16:28
 * @Description:
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
