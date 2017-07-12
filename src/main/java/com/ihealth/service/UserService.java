package com.ihealth.service;

import com.ihealth.domian.User;

import java.util.Date;
import java.util.List;

/**
 * Created by changlin on 2017/7/3.
 */
public interface UserService {
    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, String sex , Integer age, Date createTime);
    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);
    /**
     * 获取用户总量
     */
    Integer getAllUsers();
    /**
     * 删除所有用户
     */
    void deleteAllUsers();

    List<User> getUsers(Date beginDate,Date endDate);
}