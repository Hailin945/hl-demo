package hl.springframework.beans.factory.support;

import hl.springframework.beans.NoSuchBeanDefinitionException;
import hl.springframework.beans.definition.BeanDefintion;
import hl.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Hailin
 * @date 2020/2/23
 */
public class DefaultListableBeanFactory extends AbstractBeanFactory implements BeanDefinitionRegistry {

    private Map<String, Object> beans = new HashMap<>(128);
    private Map<String, BeanDefintion> beanDefinitionMap = new ConcurrentHashMap<>(256);

    public DefaultListableBeanFactory(String path) throws IOException {
        super();
        loadBeanDefinitions(path);
    }

    private void loadBeanDefinitions(String path) throws IOException {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader();
        BeanDefintion beanDefintion = reader.loadBeanDefinition(path, this);
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefintion beanDefintion) throws RuntimeException {
        this.beanDefinitionMap.put(beanName, beanDefintion);
    }

    @Override
    public BeanDefintion getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {
        return this.beanDefinitionMap.get(beanName);
    }
}
