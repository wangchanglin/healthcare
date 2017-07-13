package com.ihealth.helper.impl;

import com.ihealth.helper.MyBatisHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;

/**
 * Created by Athos on 2016-07-02.
 */
@Repository
public class MyBatisHelperImpl implements MyBatisHelper {
    @Resource
    @Qualifier("sessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    public synchronized SqlSession getSqlSession(){
        if (null == sqlSession){
            this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
        }
        return this.sqlSession;
    }
    public <T extends Mapper> T getMapper(Class<T> cls){
       return getSqlSession().getMapper(cls);
    }
}
