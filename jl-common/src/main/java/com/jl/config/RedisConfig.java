package com.jl.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import redis.clients.jedis.Jedis;

@Configuration //标识配置类
@PropertySource("classpath:/properties/redis.properties")
public class RedisConfig {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private Integer port;

    @Bean
    @Scope("prototype")	//设置为多例 当用户使用时创建
    public Jedis jedis() {
        return new Jedis(host, port);
    }
}