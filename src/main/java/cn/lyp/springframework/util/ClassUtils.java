package cn.lyp.springframework.util;

/**
 * @Author: LypCoding
 * @Date: 2025/6/19 10:07
 * @Description:
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader(){
        ClassLoader cl =null;
        try{
            cl = Thread.currentThread().getContextClassLoader();
        }catch (Throwable ex){
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }
        if(cl == null){
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }


}
