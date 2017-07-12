package com.ihealth.domian;

import java.util.Date;

/**
 * Created by changlin on 2017/7/3.
 */
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public User(Integer id, String name, Integer age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
