/*
 * Copyright 2019 ShenQi. All rights reserved.
 * You can get our information at http://www.sqinet.cn
 * Anyone can't use this file without our permission.
 */
package com.vevor.erp.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @author Administrator
 * @version 1.0
 * @description Druid的DataResource配置类
 * 凡是被Spring管理的类，实现接口 EnvironmentAware 重写方法 setEnvironment 可以在工程启动时，
 * 获取到系统环境变量和application配置文件中的变量。 还有一种方式是采用注解的方式获取 @value("${变量的key值}")
 * 获取application配置文件中的变量。 这里采用第一种要方便些
 * @date 2019/1/24 15:39
 */
@Configuration
@EnableTransactionManagement  // 开启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@MapperScan(basePackages = {"com.vevor.erp.dao"})
public class DatasourceConfig implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(environment.getProperty("spring.datasource.url"));
        datasource.setDriverClassName(environment.getProperty("spring.datasource.driverClassName"));
        datasource.setUsername(environment.getProperty("spring.datasource.username"));
        datasource.setPassword(environment.getProperty("spring.datasource.password"));
        datasource.setMinIdle(Integer.parseInt(environment.getProperty("spring.datasource.druid.min-idle")));
        datasource.setMaxWait(Long.parseLong(environment.getProperty("spring.datasource.druid.max-wait")));
        datasource.setMaxActive(Integer.valueOf(environment.getProperty("spring.datasource.druid.max-active")));
        datasource.setMinEvictableIdleTimeMillis(
                Long.parseLong(environment.getProperty("spring.datasource.druid.min-evictable-idle-time-millis")));
        datasource.setConnectionInitSqls(Collections.list(new StringTokenizer(environment.getProperty("spring.datasource.connectionInitSqls"), ";")));

        try {
            datasource.setFilters(environment.getProperty("spring.datasource.druid.filters"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datasource;
    }
}
