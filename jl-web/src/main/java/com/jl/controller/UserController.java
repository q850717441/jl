package com.jl.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jl.pojo.User;
import com.jl.service.DubboUserService;
import com.jl.vo.SysResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Reference(check = false)
    private DubboUserService dubboUserService;

    @RequestMapping("/{moduleName}")
    public String moduleName(@PathVariable String moduleName) {
        return moduleName;
    }

    /**
     * 注册功能
     * @param user
     * @return
     */
    @RequestMapping("/doRegister")
    @ResponseBody
    public SysResult doRegister(User user) {
        dubboUserService.insertUser(user);
        return SysResult.success();
    }
}
