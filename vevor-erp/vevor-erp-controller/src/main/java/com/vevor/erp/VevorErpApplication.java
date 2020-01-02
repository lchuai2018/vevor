package com.vevor.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: lichenghuai
 * @Date: 2019/12/17 18:59
 */
@ComponentScan(basePackages = "com.vevor.*")
@RefreshScope
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}
@EnableDiscoveryClient
@SpringBootApplication
public class VevorErpApplication {
    public static void main(String[] args){
        SpringApplication.run(VevorErpApplication.class,args);
    }
}
