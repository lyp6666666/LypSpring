package cn.lyp.springframework.beans;

/**
 * @Author: 53256
 * @Date: 2025/4/30 11:30
 * @Description: 自定义Bean异常
 */
public class BeansException extends RuntimeException{

    public BeansException(String message){
        super(message);
    }

    public BeansException(String message, Throwable cause){
        super(message, cause);
    }

}
