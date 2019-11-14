package com.jl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-14 09:23
 * @description:
 **/
@SpringBootApplication
@MapperScan("com.jl.mapper")   //导入mapper接口文件
public class SpringBootRun {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRun.class);
    }
}
