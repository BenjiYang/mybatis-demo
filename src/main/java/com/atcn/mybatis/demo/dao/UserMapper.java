package com.atcn.mybatis.demo.dao;

public interface UserMapper {

    public int addUser(User user);

    public int deleteById(int id);

    public User queryById(int id);

    public int updateById(User user);
}
