package hl.springframework.beans.definition;

import hl.springframework.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hailin
 * @date 2020/2/22
 */
public class BeanDefintion {

    private String name;

    private String beanClassName;

    private List<PropertyValue> propertyValues = new ArrayList<>(16);

    public BeanDefintion(String beanClassName) {
        this(null, beanClassName);
    }

    public BeanDefintion(String name, String beanClassName) {
        super();
        this.name = name;
        this.beanClassName = beanClassName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }
}
