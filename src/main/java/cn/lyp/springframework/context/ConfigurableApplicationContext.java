package cn.lyp.springframework.context;

import cn.lyp.springframework.beans.BeansException;

/**
 * @Author: LypCoding
 * @Date: 2025/6/19 17:00
 * @Description:
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;


}
