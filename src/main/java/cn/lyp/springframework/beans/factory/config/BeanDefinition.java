package cn.lyp.springframework.beans.factory.config;

import cn.lyp.springframework.beans.PropertyValues;

/**
 * @Author: 53256
 * @Date: 2025/4/30 11:32
 * @Description: BeanDefinition 是 Bean 容器的元信息定义类，
 * 主要用于封装 Bean 的 Class 类型信息。IoC 容器通过读取 BeanDefinition，
 * 获取目标 Bean 的类型，并据此进行实例化、依赖注入等操作。
 * 本类目前只包含最基本的 beanClass 信息，后续可扩展属性包括：
 * 构造函数参数、属性依赖、作用域、初始化方法、销毁方法等。
 */
public class BeanDefinition {

    private Class<?> beanClass;

    private PropertyValues propertyValues;

    private String initMethodName;

    private String destroyMethodName;


    public BeanDefinition(Class<?> beanClass){
        this.beanClass=beanClass;
        this.propertyValues = new PropertyValues();
    }


    public BeanDefinition(Class<?> beanClass , PropertyValues propertyValues){
        this.beanClass=beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }




    public Class<?> getBeanClass(){
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass){
        this.beanClass=beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }



    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }


    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName){
        this.destroyMethodName = destroyMethodName;
    }


}
