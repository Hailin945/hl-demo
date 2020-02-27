package hl.springframework.beans.factory;

/**
 * @author Hailin
 * @date 2020/2/23
 */
public interface BeanFactory {

    Object getBean(String beanName);

    Object getBean(Class<?> beanType);
}
