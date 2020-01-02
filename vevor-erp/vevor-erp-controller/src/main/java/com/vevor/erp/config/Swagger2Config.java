package com.vevor.erp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: lichenghuai
 * @Date: 2019/12/22 12:58
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {
  /*  @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vevor.erp.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger2测试")
                .description("新手上路-swagger2。https://git.oschina.net/sealde/springboot-javaconfig/tree/dev2")
                .termsOfServiceUrl("https://git.oschina.net/sealde/springboot-javaconfig/tree/dev2")
                .version("0.0.1")
                .contact(new Contact("seal_de", "https://git.oschina.net/sealde", "seal.de@foxmail.com"))
                .build();
    }*/


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vevor.erp.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //标题
                .title("司顺erp系统")
                //简介
                .description("Vevor Operation Management System")
                //服务条款
                .termsOfServiceUrl("")
                //作者个人信息
                .contact(new Contact("许义文", "", "bfo1005@dingtalk.com"))
                //版本
                .version("1.0")
                .build();
    }
}
