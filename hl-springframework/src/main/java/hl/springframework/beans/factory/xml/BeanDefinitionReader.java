package hl.springframework.beans.factory.xml;

import hl.springframework.beans.definition.BeanDefintion;
import hl.springframework.beans.factory.BeanFactory;

import java.io.IOException;

/**
 * @author Hailin
 * @date 2020/2/22
 */
public interface BeanDefinitionReader {

    BeanDefintion loadBeanDefinition(String path, BeanFactory beanFactory) throws IOException;
}
