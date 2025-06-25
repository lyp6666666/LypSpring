package cn.lyp.springframework.beans.factory.support;

import cn.lyp.springframework.beans.BeansException;
import cn.lyp.springframework.beans.factory.DisposableBean;
import cn.lyp.springframework.beans.factory.config.SingletonBeanRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: 53256
 * @Date: 2025/4/30 11:34
 * @Description:单例 Bean 注册表。
 * 在 Spring 的 IoC 容器中，单例 Bean（默认作用域）是只创建一次的；
 * 所以需要一个专门的地方来缓存已经创建好的单例对象，这就是这个类的职责；
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegister {

    private Map<String , Object> singletonObjects = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();


    /**
     * 这个方法可以被继承此类的其他类调用。包括：AbstractBeanFactory 以及继承的 DefaultListableBeanFactory 调用
     * @param beanName
     * @return
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }

    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }


    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
