package cn.lyp.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 53256
 * @Date: 2025/6/18 20:53
 * @Description:
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pc){
        propertyValueList.add(pc);
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        for(PropertyValue py : this.propertyValueList){
            if(py.getName().equals(propertyName)){
                return py;
            }
        }
        return null;
    }

}
