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

public class PoCOptimized1 {

    /**
     *
     * 如下方式使用JDK代理，在删除UserDao实现类的时候，仍然可以使用
     *
     * 五、mybatis接口的使用方式
     * 通过前面UserDao的设计，可以发现，UserDao中的代码都是模板化代码，都可以通过配置自动生成，因此，在实际开发中，Mapper可以按照如下方式设计
     * 1.定义Mapper接口
     * 2.定义映射文件
     * 3.测试
     *
     *
     * 注意：
     * 使用mapper接口方式必须满足:
     * 1.映射文件的namespace的值必须是接口的全路径名称  比如：com.atcn.mybatis.demo.dao.UserMapper
     * 2.接口中的方法名在映射文件中必须有一个id值与之对应。
     * 3.映射文件的名称必须和接口的名称一致
     */
    @Test
    public void add2() throws IOException {
        // 1.通过Resources对象加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream );
        // 3.通过SqlSessionFactory对象获取SQLSession对象
        SqlSession session = factory.openSession();
        User user = new User();
        user.setName("dpb");
        user.setAge(22);
        //通过Java动态代理自动提供了UserMapper的实现类
        UserMapper mapper = session.getMapper(UserMapper.class);
        int count = mapper.addUser(user);
        System.out.println("影响的行数:"+count);
        session.commit();
    }

}
