package com.jl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jl.mapper.UserMapper;
import com.jl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import java.util.Date;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-15 16:37
 * @description:
 **/
@Service
public class DubboUserServiceImpl implements DubboUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 1.避免后台数据库报错,暂时使用手机代替
     * 2.使用MD5加密算法  32位16进制字符串=2^128次
     * (2^4)^32=2^128
     * 3.设定操作时间
     * 注意事项:
     * 1.注册时使用加密算法
     * 2.用户登录时,加密算法必须相同
     */
    @Override
    public void insertUser(User user) {
        String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Pass)
                .setEmail(user.getPhone())
                .setCreated(new Date())
                .setUpdated(user.getCreated());
        userMapper.insert(user);
    }
}
