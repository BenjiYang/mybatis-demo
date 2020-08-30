package com.atcn.mybatis.demo.bean;

import java.util.List;

public class User {
    private int id;
    private String name;
    private int age;
    // 集合数据和表结构中的数据类型不一致，数据是Varchar类型
    private List<String> hobby;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + hobby +
                '}';
    }
}
