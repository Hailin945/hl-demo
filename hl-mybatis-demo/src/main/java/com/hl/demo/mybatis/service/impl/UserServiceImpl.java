package com.hl.demo.mybatis.service.impl;

import com.hl.demo.mybatis.dao.UserDao;
import com.hl.demo.mybatis.pojo.User;
import com.hl.demo.mybatis.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author Hailin
 * @date 2020/2/8
 */
public class UserServiceImpl implements UserService {

    private SqlSessionFactory sqlSessionFactory;

    public UserServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User getUserById(Long id) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            
            // 方式一
            UserDao userDao = session.getMapper(UserDao.class);
            User user = userDao.getUserById(id);

            /// 方式二
            // User user = session.selectOne("com.hl.demo.mybatis.dao.UserDao.getUserById", id);

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            assert session != null;
            session.close();
        }
    }
}
