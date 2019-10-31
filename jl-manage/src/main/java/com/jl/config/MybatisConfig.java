package com.jl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

@Configuration //配置类
public class MybatisConfig {
    @Bean //将对象交给Spring容器管理
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
