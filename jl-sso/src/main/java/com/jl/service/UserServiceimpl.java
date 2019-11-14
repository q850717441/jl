package com.jl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jl.mapper.UserMapper;
import com.jl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-14 09:18
 * @description:
 **/
@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //校验用户数据的有效性.是否可用
    @Override
    public boolean checkUser(String param, Integer type) {
        //String column = (type==1)?"username":(type==2?"phone":"email");
        Map<Integer, String> columnMap = new HashMap<>();
        columnMap.put(1, "username");
        columnMap.put(2, "phone");
        columnMap.put(3, "email");
        String column = columnMap.get(type);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(column, param);
        User userDB = userMapper.selectOne(queryWrapper);
        return userDB == null ? false : true;
    }

}
