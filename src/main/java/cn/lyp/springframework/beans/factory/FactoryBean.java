package cn.lyp.springframework.beans.factory;

/**
 * @Author: LypCoding
 * @Date: 2025/6/24 15:55
 * @Description:
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
