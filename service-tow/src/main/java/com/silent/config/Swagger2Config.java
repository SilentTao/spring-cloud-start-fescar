package com.silent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * \* User: silent
 * \* Date: 17-9-15 Time: 下午3:04
 * \* Description: swagger2 配置类
 * \
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {


    @Bean
    public Docket createRestApi() {
        //添加全局header参数
        ParameterBuilder parameterToken = new ParameterBuilder();
        ParameterBuilder parameterScene = new ParameterBuilder();
        ParameterBuilder parameterLanguage = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameterToken.name("token").description("令牌,v4及其以上接口都需要").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        parameterScene.name("scene").description("场景,需要做场景区分的接口").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        parameterLanguage.name("language").description("语言,需要做语言区分的接口").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        parameters.add(parameterToken.build());
        parameters.add(parameterScene.build());
        parameters.add(parameterLanguage.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pmpd.auth"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("auth模块API")
                .description("1.登录注册  \n" +
                        "2.账号绑定  \n" +
                        "3.第三方登录/绑定  \n" +
                        "3.宝宝管理  \n" +
                        "4.用户反馈  \n" +
                        "5.用户目标  \n")
                .version("2.0")
                .build();
    }


}
