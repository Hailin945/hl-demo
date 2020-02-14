package com.hl.demo.mybatis.service;

import com.hl.demo.mybatis.pojo.User;
import com.hl.demo.mybatis.service.impl.UserServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @author Hailin
 * @date 2020/2/8
 */
public class UserServiceTest {

    private SqlSessionFactory sqlSessionFactory;

    private final String resource = "mybatis/config/mybatis-config.xml";

    @Before
    public void setUp() {
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUserById() {
        UserService userService = new UserServiceImpl(sqlSessionFactory);
        User user = userService.getUserById(1L);
        System.out.println(user);
    }
}
