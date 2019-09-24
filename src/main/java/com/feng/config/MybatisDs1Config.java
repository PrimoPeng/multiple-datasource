package com.feng.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author: pengchangxu
 * @Description:
 * @Date 2019/6/1
 */

//@Configuration
@MapperScan(basePackages = "com.feng.ds1.mapper", sqlSessionTemplateRef = "sqlSessionTemplate1")
public class MybatisDs1Config {

    @Autowired
    @Qualifier("ds1")
    private DataSource ds1;

    @Bean
    public SqlSessionFactory sqlSessionFactory1() throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds1);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception{
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1());
        return template;
    }

}