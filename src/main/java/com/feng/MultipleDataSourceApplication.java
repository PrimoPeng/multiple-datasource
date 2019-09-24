package com.feng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: pengchangxu
 * @Description:
 * @Date 2019/5/30
 */
@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MultipleDataSourceApplication {

    public static void main(String[] args){
        SpringApplication.run(MultipleDataSourceApplication.class, args);
    }
}
