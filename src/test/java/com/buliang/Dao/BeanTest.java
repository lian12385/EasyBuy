package com.buliang.Dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( "classpath:applicationContext.xml")
public class BeanTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private SqlSessionFactoryBean sqlSessionFactoryBean;

    @Test
    public void test(){
        System.out.println(dataSource);
        System.out.println(sqlSessionFactoryBean);
    }
}
