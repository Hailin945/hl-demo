package com.hl.multithreading.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author Hailin
 * @date 2020/3/6
 */
public class IntrospectorDemo {

    public static void main(String[] args) throws Exception{
        User user = new User();
        user.setUsername("张三");
        user.setAge(10);

        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String name = propertyDescriptor.getName();
            Class<?> propertyType = propertyDescriptor.getPropertyType();
            Method readMethod = propertyDescriptor.getReadMethod();
            Method writeMethod = propertyDescriptor.getWriteMethod();

            System.out.println("name: " + name);
            System.out.println("propertyType: " + propertyType);
            System.out.println("readMethod: " + readMethod);
            System.out.println("writeMethod: " + writeMethod);

            if ("age".equals(name)) {
                writeMethod.invoke(user, 100);
                Object invoke = readMethod.invoke(user);
                System.out.println(user.getAge());
            }
        }
    }
}
