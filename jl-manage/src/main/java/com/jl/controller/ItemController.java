package com.jl.controller;

import com.jl.service.ItemService;
import com.jl.vo.EasyUITable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //保证返回值数据都是JSON时使用
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 根据条件查询数据信息.
     * url:http://localhost:8091/item/query?page=1&rows=20
     */
    @RequestMapping("/query")
    public EasyUITable findItemByPage(Integer page, Integer rows) {
        return itemService.findItemByPage(page, rows);
    }

}
