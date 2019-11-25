package com.jl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-25 10:22
 * @description:
 **/
@SpringBootApplication
@MapperScan("com.jl.mapper") //为mapper接口创建代理对象
public class SpringBootRun {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRun.class,args);
    }
}
