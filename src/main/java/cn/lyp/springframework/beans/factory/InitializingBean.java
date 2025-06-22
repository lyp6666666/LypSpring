package cn.lyp.springframework.beans.factory;

/**
 * @Author: LypCoding
 * @Date: 2025/6/22 20:42
 * @Description: Bean初始化顶层接口
 */
public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;

}

