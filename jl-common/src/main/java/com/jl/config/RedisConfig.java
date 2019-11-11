package com.jl.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * 实现spring容器管理redis配置类
 * @author Administrator
 *
 */
@Configuration //标识配置类
@PropertySource("classpath:/properties/redis.properties")
public class RedisConfig {

    @Value("${redis.nodes}")
    private String nodes;

    /**
     * 将set集合交给容器管理
     * @return
     */
    @Bean("redisSet")
    public Set<HostAndPort> redisSet(){
        Set<HostAndPort> redisSet = new HashSet<>();
        String[] arrayNodes = nodes.split(",");
        for (String node : arrayNodes) {
            String host = node.split(":")[0];
            int port = Integer.parseInt(node.split(":")[1]);
            HostAndPort hostAndPort = new HostAndPort(host,port);
            redisSet.add(hostAndPort);
        }
        return redisSet;
    }

    @Bean
    @Scope("prototype")
    public JedisCluster jedisCluster(@Qualifier("redisSet")Set<HostAndPort> redisSet){

        return new JedisCluster(redisSet);
    }
}








