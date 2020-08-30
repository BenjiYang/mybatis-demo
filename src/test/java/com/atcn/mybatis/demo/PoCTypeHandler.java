package com.atcn.mybatis.demo;

import com.atcn.mybatis.demo.bean.User;
import com.atcn.mybatis.demo.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PoCTypeHandler {

    @Test
    public void add3() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();

        User user = new User();
        user.setId(7);
        user.setName("Tom4TypeHandler");
        user.setAge(22);
        // Type handler demo
        List<String> list = new ArrayList<String>();
        list.add("dnf");
        list.add("cs");
        list.add("cf");
        user.setHobby(list);

        UserMapper mapper = session.getMapper(UserMapper.class);
        int count = mapper.addUser(user);
        System.out.println("影响的行数:" + count);
        session.commit();
    }

    @Test
    public void testHabbyReturnList() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream );
        SqlSession session = factory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryById(7);
        System.out.println(user);
        session.commit();
    }

}
