package com.hus.common.swagger;


import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by zzh on 16/9/12.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.POST,
                        newArrayList(
                                new ResponseMessageBuilder()
                                        .code(0)
                                        .message("请求成功，返回结果")
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(-1)
                                        .message("系统错误，请提交Bug")
                                        .responseModel(new ModelRef("Error"))
                                        .build()
                        ));
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "标题",
                "描述",
                "1.0",
                "",
                new Contact("朱昊", "", ""),
                "zhuhao.info",
                "zhuhao.info");
    }

}
