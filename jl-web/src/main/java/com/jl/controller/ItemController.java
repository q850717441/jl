package com.jl.controller;

import com.jl.pojo.Item;
import com.jl.pojo.ItemDesc;
import com.jl.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    //jl-web服务器

    @Autowired
    private ItemService itemService;

    //${item.title }
    //${itemDesc.itemDesc} 获取商品详情信息
    @RequestMapping("/{itemId}")
    public String toItems(@PathVariable Long itemId,Model model) {
        //根据商品ID号查询后台商品数据
        Item item = itemService.findItemById(itemId);
        model.addAttribute("item", item);
        ItemDesc itemDesc = itemService.findItemDescById(itemId);
        model.addAttribute("itemDesc", itemDesc);
        return "item"; //动态的商品展现页面
    }
}
