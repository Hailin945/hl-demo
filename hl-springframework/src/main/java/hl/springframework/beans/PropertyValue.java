package hl.springframework.beans;

import com.sun.istack.internal.Nullable;

/**
 * @author Hailin
 * @date 2020/2/23
 */
public class PropertyValue {

    private String name;

    @Nullable
    private Object value;

    public PropertyValue() {
        this(null, null);
    }

    public PropertyValue(String name) {
        this(name, null);
    }

    public PropertyValue(String name, Object value) {
        super();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
