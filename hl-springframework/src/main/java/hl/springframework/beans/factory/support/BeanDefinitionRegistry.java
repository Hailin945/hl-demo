package hl.springframework.beans.factory.support;

import hl.springframework.beans.BeanDefinitionStoreException;
import hl.springframework.beans.NoSuchBeanDefinitionException;
import hl.springframework.beans.definition.BeanDefintion;

/**
 * @author Hailin
 * @date 2020/2/24
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefintion beanDefintion) throws BeanDefinitionStoreException;

    BeanDefintion getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException;
}
