package cn.lyp.springframework.beans.factory.config;

/**
 * @Author: 53256
 * @Date: 2025/6/18 21:57
 * @Description:
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
