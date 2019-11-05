package com.jl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-05 09:49
 * @description:
 **/
@RestController
public class MessageController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/getPort")
    public String getMsg() {
        return "当前端口为:" + port;
    }
}
