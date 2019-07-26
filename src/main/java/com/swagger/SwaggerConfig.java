package com.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * \* Author: 姬雨航
 * \* Date: 2019/7/24 15:42
 * \* Description：
 * \
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                /** Api文档信息配置 */
                .apiInfo(apiInfo())
                .select()
                /** 配置Api包扫描 */
                .apis(RequestHandlerSelectors.basePackage("com.swagger"))
                /** 配置路径（PathSelectors.any（）所有路径） */
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * Api文档信息配置
     * @return
     */
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot整合Swagger构建api文档")
                .description("这里是说明")
                .version("1.0")
                .build();
    }

}
