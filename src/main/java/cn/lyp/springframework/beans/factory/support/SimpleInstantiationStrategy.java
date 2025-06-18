package cn.lyp.springframework.beans.factory.support;

import cn.lyp.springframework.beans.BeansException;
import cn.lyp.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: 53256
 * @Date: 2025/4/30 17:36
 * @Description:
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName , Constructor ctor, Object[] args )throws BeansException{
        Class<?> clazz = beanDefinition.getBeanClass();
        try{
            if(ctor !=null ){
                //有参构造
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else{
                //无参构造,把入参信息传递给 newInstance 进行实例化。
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException| NoSuchMethodException e) {
            throw new BeansException("Fail to instantiate [" +clazz.getName()+"]",e);
        }

    }

}
