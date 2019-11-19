package com.jl.config;

import com.jl.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private UserInterceptor userInterceptor;

    //开启匹配后缀型配置,/user 与 /user.*的效果相同
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

        configurer.setUseSuffixPatternMatch(true);
    }

    /**
     * 添加用户的拦截器
     * 添加需要匹配的路径
     * url:localhost:8090/addUser/a/b
     * /** 表示拦截所有(多级)的请求    对
     * /*  表示拦截一级目录请求	      错
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor).addPathPatterns("/cart/**", "/order/**");
        //如果有多个拦截器,可以addInterceptor多次
    }
}
