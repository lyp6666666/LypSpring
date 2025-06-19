package cn.lyp.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: LypCoding
 * @Date: 2025/6/19 10:16
 * @Description: 指定文件路径读取文件信息
 */
public class FileSystemResource implements Resource{

    private final File file;

    private final String path;

    public FileSystemResource(File file){
        this.file = file;
        this.path = this.file.getPath();
    }

    public FileSystemResource(String path){
        this.file = new File(path);
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException{
        return new FileInputStream(this.file);
    }

    public final String getPath(){
        return this.path;
    }


}
