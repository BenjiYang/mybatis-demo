package com.atcn.mybatis.demo;

import com.atcn.mybatis.demo.dao.User;
import com.atcn.mybatis.demo.dao.UserMapper;
import com.atcn.mybatis.demo.utils.DBUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PoC2 {

    @Test
    public void test() {
        UserMapper mapper = (UserMapper) Proxy.newProxyInstance(UserMapper.class.getClassLoader()
                , new Class[]{UserMapper.class},new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(UserMapper.class.getName()+"."+method.getName());
                        Object id = null;
                        for (Object object : args) {
                            System.out.println(object);
                            id = object;
                        }

                        // 实现逻辑
                        return DBUtils.getInstace().openSession().selectOne(UserMapper.class.getName()+"."+method.getName(), id);
                    }
                } );
        System.out.println(mapper.queryById(5));
    }

}
