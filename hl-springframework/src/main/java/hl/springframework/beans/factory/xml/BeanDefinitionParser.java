package hl.springframework.beans.factory.xml;


import hl.springframework.beans.PropertyValue;
import hl.springframework.beans.definition.BeanDefintion;
import hl.springframework.beans.definition.RuntimeBeanReference;
import hl.springframework.beans.definition.TypeStringValue;
import hl.springframework.beans.factory.BeanFactory;
import org.dom4j.Element;

import java.util.List;

/**
 * @author Hailin
 * @date 2020/2/22
 */
public class BeanDefinitionParser {

    private BeanFactory beanFactory;

    public BeanDefinitionParser(BeanFactory beanFactory) {
        super();
        this.beanFactory = beanFactory;
    }

    public void parseRootElement(Element rootElement) {
        if (rootElement == null) {
            return;
        }
        @SuppressWarnings("unchecked")
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            parseBeanElement(element);
        }
    }

    private void parseBeanElement(Element beanElement) {
        if (beanElement == null) {
            return;
        }
        String id = beanElement.attributeValue("id");
        String clazz = beanElement.attributeValue("class");

        BeanDefintion beanDefintion = new BeanDefintion(id, clazz);

        @SuppressWarnings("unchecked")
        List<Element> propertyElements = beanElement.elements();
        for (Element element : propertyElements) {
            parsePropertyElement(element, beanDefintion);
        }
    }

    private void parsePropertyElement(Element propertyElement, BeanDefintion beanDefintion) {
        if (propertyElement == null) {
            return;
        }
        String name = propertyElement.attributeValue("name");
        String value = propertyElement.attributeValue("value");
        String ref = propertyElement.attributeValue("ref");
        PropertyValue propertyValue = new PropertyValue();
        propertyValue.setName(name);
        // value 和 ref 只能有一个
        boolean isValue = value != null && !"".equals(value);
        boolean isRef = ref != null && !"".equals(value);
        if (isValue && isRef) {
            throw new RuntimeException("property标签中value属性和ref属性同时存在！");
        }
        if (isValue) {
            TypeStringValue typeStringValue = new TypeStringValue(value);
            propertyValue.setValue(typeStringValue);
        }
        if (isRef) {
            RuntimeBeanReference reference = new RuntimeBeanReference(ref);
            propertyValue.setValue(reference);
        }
        beanDefintion.getPropertyValues().add(propertyValue);
        registryBeanDefinition(name, beanDefintion);
    }

    private void registryBeanDefinition(String beanName, BeanDefintion beanDefintion) {
        this.beanFactory.registryBeanDefinition(beanName, beanDefintion);
    }
}
