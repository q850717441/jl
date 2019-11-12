package com.jl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-12 09:19
 * @description:
 **/
@Controller
@RequestMapping("/items/")
public class ItemController {
    @RequestMapping("{itemId}")
    public String toItems(@PathVariable long itemId){
        System.out.println("当前商品ID:"+itemId);
        return "item";
    }
}
