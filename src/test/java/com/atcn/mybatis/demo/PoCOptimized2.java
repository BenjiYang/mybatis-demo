package com.atcn.mybatis.demo;

import com.atcn.mybatis.demo.dao.UserMapper;
import com.atcn.mybatis.demo.utils.DBUtils;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PoCOptimized2 {

    /**
     * PoCOptimized1 - Using UserMapperOptimized.xml configuration
     */

    @Test
    public void test(){
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
                        return DBUtils.getInstance().openSession().selectOne(UserMapper.class.getName()+"."+method.getName(), id);
                    }
                } );
        System.out.println(mapper.queryById(1));
    }

}
