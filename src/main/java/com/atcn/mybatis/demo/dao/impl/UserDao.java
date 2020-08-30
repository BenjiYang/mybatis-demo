package com.atcn.mybatis.demo.dao.impl;

import com.atcn.mybatis.demo.bean.User;
import com.atcn.mybatis.demo.dao.UserMapper;
import com.atcn.mybatis.demo.common.DBUtils;

public class UserDao implements UserMapper {

    /**
     * PoCOptimized1 - Using UserMapperOptimized.xml configuration
     */

    // 3.Use SqlSessionFactory object to get SQLSession object - openSession()
    public int addUser(User user) {
        return DBUtils.getInstance().openSession().insert("com.atcn.mybatis.demo.dao.UserMapper.addUser", user);
    }

    public int deleteById(int id) {
        return DBUtils.getInstance().openSession().delete("com.atcn.mybatis.demo.dao.UserMapper.deleteUserById", id);
    }

    public User queryById(int id) {
        return DBUtils.getInstance().openSession().selectOne("com.atcn.mybatis.demo.dao.UserMapper.getUserById", id);
    }

    public int updateById(User user) {
        return DBUtils.getInstance().openSession().update("com.atcn.mybatis.demo.dao.UserMapper.updateUserById", user);
    }
}
