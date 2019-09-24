package com.cimc.config;

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
 * @author chenz
 * @create 2019-09-23 16:51
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 管理的接口包路径
                .apis(RequestHandlerSelectors.basePackage("com.cimc.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置页面展示的基本信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("信息发布系统")
                .description("信息发布系统 API1.0 操作文档")
                //服务条款⽹网址
                .termsOfServiceUrl("https://github.com/BusyAnts")
                .version("1.0")
                .contact(new Contact("BusyAnts", "https://github.com/BusyAnts", "chenz16888@163.com "))
                .build();
    }

}
