package cn.lyp.springframework.beans.factory;

/**
 * @Author: LypCoding
 * @Date: 2025/6/23 16:30
 * @Description:
 */
public interface BeanClassLoaderAware extends Aware{

    void setBeanClassLoader(ClassLoader classLoader);
}
