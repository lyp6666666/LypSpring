package cn.lyp.springframework.beans.factory;

import cn.lyp.springframework.beans.BeansException;
import cn.lyp.springframework.beans.factory.config.BeanDefinition;

/**
 * @Author: 53256
 * @Date: 2025/4/30 11:32
 * @Description: 主要职责：1.根据名字获取Bean   2.维护 bean 的注册表
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name,Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
