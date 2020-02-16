package com.hl.demo.spring;

import com.hl.demo.spring.bean.MyTestBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


/**
 * @author Hailin
 * @date 2020/2/14
 */
public class BeanFactoryTest {

    @Test
    public void testBeanFactoryLoad() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring/spring-config.xml"));
        MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
        Assert.assertEquals("testStr", myTestBean.getTestStr());
    }

    @Test
    public void testApplicationContextLoad() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        MyTestBean myTestBean = (MyTestBean) context.getBean("myTestBean");
        Assert.assertEquals("testStr", myTestBean.getTestStr());
    }
}
