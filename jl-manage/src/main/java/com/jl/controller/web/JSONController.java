package com.jl.controller.web;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jl.pojo.ItemDesc;
import com.jl.util.ObjectMapperUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-14 08:50
 * @description:
 **/
@RestController
public class JSONController {
    //约定回调函数名称 callback
    //@RequestMapping("/web/testJSONP")
    public String testJSONPOld(String callback) {
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(10001L)
                .setItemDesc("商品详情信息!!!!!!");
        String json = ObjectMapperUtil.toJSON(itemDesc);
        return callback + "(" + json + ")";
    }

    //利用API实现JSONP跨域访问
    @RequestMapping("/web/testJSONP")
    public JSONPObject testJSONP(String callback) {
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(10001L)
                .setItemDesc("商品详情信息!!!!!!");
        return new JSONPObject(callback, itemDesc);
    }
}
