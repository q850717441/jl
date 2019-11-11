package com.jt;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-11 14:14
 * @description:
 **/
public class TestCluster {
    @Test
    public void test01(){
        Set<HostAndPort> nodes =new HashSet<>();
        nodes.add(new HostAndPort("192.168.56.129",7000));
        nodes.add(new HostAndPort("192.168.56.129",7001));
        nodes.add(new HostAndPort("192.168.56.129",7002));
        nodes.add(new HostAndPort("192.168.56.129",7003));
        nodes.add(new HostAndPort("192.168.56.129",7004));
        nodes.add(new HostAndPort("192.168.56.129",7005));
        JedisCluster jediscluster = new JedisCluster(nodes);
    }
}
