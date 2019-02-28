package com.silent.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * \* User: silent
 * \* Date: 17-8-31 Time: 下午2:32
 * \* Description: 配置打印feign请求详细信息
 * \
 */
@Configuration
public class FeignLogConfig {


    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
