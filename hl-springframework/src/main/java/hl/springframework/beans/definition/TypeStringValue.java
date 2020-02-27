package hl.springframework.beans.definition;

/**
 * @author Hailin
 * @date 2020/2/23
 */
public class TypeStringValue {

    private String value;

    private Object targetType;

    public TypeStringValue(String value) {
        super();
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Object getTargetType() {
        return targetType;
    }

    public void setTargetType(Object targetType) {
        this.targetType = targetType;
    }
}
