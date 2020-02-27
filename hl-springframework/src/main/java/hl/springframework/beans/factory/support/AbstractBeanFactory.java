package hl.springframework.beans.factory.support;

import hl.springframework.beans.factory.BeanFactory;

/**
 * @author Hailin
 * @date 2020/2/23
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    @Override
    public Object getBean(String beanName) {
        return null;
    }

    @Override
    public Object getBean(Class<?> beanType) {
        return null;
    }
}
