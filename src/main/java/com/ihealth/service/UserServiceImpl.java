package com.ihealth.service;

import com.ihealth.domian.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by changlin on 2017/7/3.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;
    @Override
    public void create(String name, String sex , Integer age, Date createTime) {
        jdbcTemplate.update("insert into USER(NAME,sex, AGE,createtime) values(?,?,?,?)", name,sex, age,createTime);
    }
    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where NAME = ?", name);
    }
    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }
    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }

    @Override
    public List<User> getUsers(Date beginDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2016);
        beginDate = calendar.getTime();
        String sql ="SELECT * FROM `user` WHERE createTime >= :beginDate and createTime<= :endDate";
        //jdbcTemplate.query()
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
        MapSqlParameterSource whereMap = new MapSqlParameterSource();
        whereMap.addValue("beginDate",beginDate);
        whereMap.addValue("endDate",new Date());
        List<User> users1 = namedParameterJdbcTemplate.query(sql,whereMap,rowMapper);

        //List<User> users= jdbcTemplate.query(sql,new Object[]{beginDate,new Date()}, rowMapper);
        return users1;
    }
}
