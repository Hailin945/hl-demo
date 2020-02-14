package com.hl.demo.mybatis.dao;

import com.hl.demo.mybatis.pojo.User;

/**
 * @author Hailin
 * @date 2020/2/6
 */
public interface UserDao {

    User getUserById(Long id);

    User getUserByName(String username);
}
