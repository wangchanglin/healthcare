package com.ihealth.helper;

import org.apache.ibatis.session.SqlSession;
import tk.mybatis.mapper.common.Mapper;


public interface MyBatisHelper {
    SqlSession getSqlSession();
    <T extends Mapper> T getMapper(Class<T> cls);
}
