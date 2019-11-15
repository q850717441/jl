package com.jl.service;

import com.jl.pojo.User;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-15 16:32
 * @description:定于dubbo的UserService接口
 **/
public interface DubboUserService {

    void insertUser(User user);
}
