package com.jl.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jl.service.UserService;
import com.jl.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-14 09:08
 * @description:
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 利用JSONP实现用户信息校验
     */
    @RequestMapping("/check/{param}/{type}")
    public JSONPObject checkUser(@PathVariable String param, @PathVariable Integer type, String callback) {
        //校验用户信息
        boolean result = userService.checkUser(param, type);
        SysResult sysResult = SysResult.success(result);
        return new JSONPObject(callback, sysResult);
    }
}
