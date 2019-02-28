package com.silent.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * \* User: silent
 * \* Date: 17-8-29 Time: 下午7:41
 * \* Description: 开启跨域访问
 * \
 */
@SuppressWarnings("Duplicates")
@Configuration
public class CorsConfig {

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setMaxAge(18000L); //预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        corsConfiguration.setAllowCredentials(true); // 允许cookies跨域
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("OPTIONS");// 允许提交请求的方法，*表示全部允许
        corsConfiguration.addAllowedMethod("HEAD");
        corsConfiguration.addAllowedMethod("GET");// 允许Get的请求方法
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("DELETE");
        corsConfiguration.addAllowedMethod("PATCH");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}
