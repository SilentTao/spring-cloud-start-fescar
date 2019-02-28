package com.silent.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.dmap.schedule.annotation.EnableElasticJob;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author guanming
 * @date 18-7-12上午10:18
 * @Description: 配置数据源
 */
@Component
@EnableElasticJob
public class DataSourcConfig {

    @Value("${elastic.job.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${elastic.job.datasource.url}")
    private String url;

    @Value("${elastic.job.datasource.username}")
    private String username;

    @Value("${elastic.job.datasource.password}")
    private String password;

    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSourceOne(){
        return new DruidDataSource();
    }

    @Bean("datasourcelog")
    public DataSource dataSourceTwo(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


}
