package com.atcn.mybatis.demo.dao;

import com.atcn.mybatis.demo.bean.User;

public interface UserMapper {

    public int addUser(User user);

    public int deleteById(int id);

    public User getUserById(int id);

    public int updateById(User user);
}
