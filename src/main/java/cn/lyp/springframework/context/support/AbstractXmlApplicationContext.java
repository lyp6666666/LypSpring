package cn.lyp.springframework.context.support;

import cn.lyp.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.lyp.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.lyp.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: LypCoding
 * @Date: 2025/6/19 19:09
 * @Description: 上下文中对配置信息的加载
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {


    @Override
    protected void loadBeanDefinition(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory,this);
        String[] configLocations = getConfigLocations();
        if(null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }



    protected abstract String[] getConfigLocations();


}
