package com.imooc.config;

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

@Configuration
@EnableSwagger2
public class Swagger2 {
//    http://localhost:8088/swagger-ui.html     原路径
//    http://localhost:8088/doc.html     原路径

    // 配置swagger2核心配置 docket
    @Bean
    public Docket createApi() {
        return new Docket(DocumentationType.SWAGGER_2) //指定文档类型为Swagger2
                    .apiInfo(apiInfo()) //用于定义api汇总信息
                    .select()
                    .apis(RequestHandlerSelectors
                            .basePackage("com.imooc.controller")) //扫描controller包
                    .paths(PathSelectors.any()) //扫描包下所有类
                    .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("天天吃货 电商平台接口api") //文档标题
                .contact(new Contact("imooc",
                        "http://www.imooc.com",
                        "TUSK@gmail.com")) //联系人信息
                .description("专为天天吃货提供的api文档") //文档描述
                .version("1.0.1") //版本号
                .build();
    }
}
