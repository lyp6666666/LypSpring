package cn.lyp.springframework.beans.factory.config;

/**
 * @Author: 53256
 * @Date: 2025/4/30 11:32
 * @Description: 支持单例注册和获取,为了保证 bean 的单例特性，我们把单例相关功能抽取成接口和实现类
 * 定义了一个获取单例对象的接口
 */
public interface SingletonBeanRegister {

    Object getSingleton(String beanName);


    /**
     * 销毁单例对象
     */
    void destroySingletons();

}
