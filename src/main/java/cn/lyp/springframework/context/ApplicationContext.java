package cn.lyp.springframework.context;

import cn.lyp.springframework.beans.factory.HierarchicalBeanFactory;
import cn.lyp.springframework.beans.factory.ListableBeanFactory;
import cn.lyp.springframework.core.io.ResourceLoader;

/**
 * @Author: LypCoding
 * @Date: 2025/6/19 16:59
 * @Description: 定义上下文接口
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {


}
