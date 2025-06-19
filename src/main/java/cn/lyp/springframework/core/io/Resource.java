package cn.lyp.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;


/**
 * @Author: LypCoding
 * @Date: 2025/6/19 9:59
 * @Description: 这个包主要用于处理资源加载流
 * 实现三种流文件操作：classPath、FileSystem、URL
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
