package cn.lyp.springframework.context;

import cn.lyp.springframework.beans.BeansException;
import cn.lyp.springframework.beans.factory.Aware;

/**
 * @Author: LypCoding
 * @Date: 2025/6/23 17:01
 * @Description:
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
