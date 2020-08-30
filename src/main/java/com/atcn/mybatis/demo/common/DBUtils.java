package com.atcn.mybatis.demo.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class DBUtils {

    private static SqlSessionFactory factory;

    public static SqlSessionFactory getInstance() {
        if (factory == null) {
            InputStream in = null;
            try {
                // 1. Load mybatis-config.xml file
                in = Resources.getResourceAsStream("mybatis-config.xml");
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (DBUtils.class) {
                if (factory == null) {
                    // 2.Get SqlSessionFactory object
                    factory = new SqlSessionFactoryBuilder().build(in);
                }
            }
        }
        return factory;
    }
}
