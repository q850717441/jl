package com.jl.controller.web;

import com.jl.pojo.Item;
import com.jl.pojo.ItemDesc;
import com.jl.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-12 09:32
 * @description:
 **/
@RestController //返回数据都是JSON串
@RequestMapping("/web/item")
public class WebItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/findItemById")
    public Item findItemById(Long itemId) {

        return itemService.findItemById(itemId);
    }

    //查询商品详情信息
    @RequestMapping("/findItemDescById")
    public ItemDesc findItemDescById(Long itemId) {

        return itemService.findItemDescById(itemId);
    }

}
