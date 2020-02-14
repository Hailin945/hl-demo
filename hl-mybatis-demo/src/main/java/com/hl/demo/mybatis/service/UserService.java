package com.hl.demo.mybatis.service;

import com.hl.demo.mybatis.pojo.User;

/**
 * @author Hailin
 * @date 2020/2/8
 */
public interface UserService {

    User getUserById(Long id);
}
