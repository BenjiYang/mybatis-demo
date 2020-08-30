package com.atcn.mybatis.demo;

import com.atcn.mybatis.demo.dao.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;

public class PoC {

    /**
     * PoC - Using UserMapper.xml configuration
     */

    private SqlSession session;

    @BeforeTest
    public void setUp() throws IOException {
        // 1. Load mybatis-config.xml file
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.Get SqlSessionFactory object
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        // 3.Use SqlSessionFactory object to get SQLSession object
        session = factory.openSession();
    }

    // 4. SQL operations - INSERT
    @Test
    public void add() {
        // INSERT EXAMPLE
        User user = new User();
        user.setId(5);
        user.setName("Ellen");
        user.setAge(23);

        int insert = session.insert("com.atcn.mybatis.demo.dao.addUser", user);
        System.out.println("Impacted row numbers：" + insert);
    }

    // 4. SQL operations - DELETE
    @Test
    public void delete() {
        // DELETE EXAMPLE
        int delete = session.delete("com.atcn.mybatis.demo.dao.deleteUserById", 5);
        System.out.println("Impacted row numbers：" + delete);
    }

    // 4. SQL operations - SELECT
    @Test
    public void search() {
        // SELECT EXAMPLE
        User search = (User) session.selectOne("com.atcn.mybatis.demo.dao.getUserById", 2);
        System.out.println("Selected User is：" + search.toString());
    }

    // 4. SQL operations - UPDATE
    @Test
    public void update() {
        // UPDATE EXAMPLE
        User user = new User();
        user.setId(2);
        user.setName("Bengi");

        int modify = session.update("com.atcn.mybatis.demo.dao.updateUserById", user);
        System.out.println("Impacted row numbers：" + modify);
    }

    @AfterTest
    public void tearDown() {
        // 5. Commit changes and close the connection
        session.commit();
        session.close();
    }

}
