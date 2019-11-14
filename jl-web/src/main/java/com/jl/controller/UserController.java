package com.jl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-14 08:54
 * @description:
 **/
//实现user业务逻辑功能  需要页面跳转
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/{moduleName}")
    public String moduleName(@PathVariable String moduleName) {
        return moduleName;
    }
}
