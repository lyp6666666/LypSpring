package cn.lyp.springframework.beans.factory.support;

import cn.lyp.springframework.beans.BeansException;
import cn.lyp.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @Author: 53256
 * @Date: 2025/4/30 17:47
 * @Description:
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName , Constructor ctor,Object[] args) throws BeansException{
        Enhancer enhancer = new Enhancer();
        //设置要被代理的类
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        //回调
        enhancer.setCallback(new NoOp(){
            @Override
            public int hashCode(){
                return super.hashCode();
            }
        });
        if(ctor == null) return enhancer.create();
        return enhancer.create(ctor.getParameterTypes(),args);
    }



}
