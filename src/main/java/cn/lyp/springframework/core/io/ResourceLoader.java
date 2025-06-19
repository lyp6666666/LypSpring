package cn.lyp.springframework.core.io;

/**
 * @Author: LypCoding
 * @Date: 2025/6/19 13:23
 * @Description: 资源加载器:定义获取资源接口，里面传递 location 地址即可。
 */
public interface ResourceLoader {


    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
