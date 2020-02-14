package com.hl.demo.spring.test;

import com.hl.demo.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Hailin
 * @date 2020/2/14
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        UserService userService = (UserService) context.getBean("userService");
        String s = userService.sayHello();
        System.out.println(s);
    }
}
