package cn.lyp.springframework.beans;

/**
 * @Author: 53256
 * @Date: 2025/6/18 20:53
 * @Description:
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name,Object value){
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public Object getValue(){
        return value;
    }

}
