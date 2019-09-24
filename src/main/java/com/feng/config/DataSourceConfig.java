package com.feng.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: pengchangxu
 * @Description:
 * @Date 2019/6/1
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "ds1")
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    public DataSource dataSource1(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ds2")
    @ConfigurationProperties(prefix = "spring.datasource.ds2")
    public DataSource dataSource2(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSource1());

        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap(5);
        dsMap.put("ds1", dataSource1());
        dsMap.put("ds2", dataSource2());

        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }

}
