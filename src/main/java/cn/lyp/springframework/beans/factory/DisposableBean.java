package cn.lyp.springframework.beans.factory;


/**
 * @Author: LypCoding
 * @Date: 2025/6/22 20:43
 * @Description: Bean销毁顶层接口
 */
public interface DisposableBean {

    void destroy() throws Exception;

}
