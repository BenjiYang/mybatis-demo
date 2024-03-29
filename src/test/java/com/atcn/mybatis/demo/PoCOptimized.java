package com.atcn.mybatis.demo;

import com.atcn.mybatis.demo.dao.UserMapper;
import com.atcn.mybatis.demo.common.DBUtils;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PoCOptimized {

    /**
     *
     * 如下方式使用JDK代理，在删除UserDao实现类的时候，仍然可以使用
     *
     * 使用UserMapper接口与xml中namespace映射，调用与之对应id方法
     *
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
        System.out.println(mapper.getUserById(1));
    }

}
