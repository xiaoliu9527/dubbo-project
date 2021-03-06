package com.wzl.study.springboot.dubboclient.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 *  Swagger2 配置
 */
@Configuration
@ConditionalOnProperty(prefix = "swagger",value = {"enable"},havingValue = "true")//设置Swagger2是否开启，通过其控制生产上关闭
public class Swagger2Config {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wzl.study.springboot.dubboclient.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restfun风格")
                .version("1.0")
                .termsOfServiceUrl("http://blog.csdn.net/penyoudi1")
                .build();
    }
}
