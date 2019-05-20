package com.vincent.evaluating_system.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：18:22
 */

@Configuration
@MapperScan("com.vincent.evaluating_system.dao")
public class MybatisConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
