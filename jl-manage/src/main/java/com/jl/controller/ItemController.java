package com.jl.controller;

import com.jl.pojo.Item;
import com.jl.service.ItemService;
import com.jl.vo.EasyUITable;
import com.jl.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController  //保证返回值数据都是JSON时使用
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     *    根据条件查询数据信息.
     *  url:http://localhost:8091/item/query?page=1&rows=20
     */
    @RequestMapping("/query")
    public EasyUITable findItemByPage
    (Integer page,Integer rows) {

        return itemService.findItemByPage(page,rows);
    }


    /**
     *  实现商品新增
     */
    @RequestMapping("/save")
    public SysResult saveItem(Item item) {

        itemService.saveItem(item);
        return SysResult.success();
    }

    /**
     * 实现商品更新
     */
    @RequestMapping("/update")
    public SysResult updateItem(Item item) {

        itemService.updateItem(item);
        return SysResult.success();
    }



    /**
     *   商品下架
     * url:/item/instock
     * type:post
     * params:{ids:111,222}
     */
    @RequestMapping("instock")
    public SysResult instockItem(Long[] ids) {

        int status = 2;	//表示下架
        itemService.updateStatus(ids,status);
        return SysResult.success();
    }

    /**
     *   商品上架
     * url:/item/reshelf
     * type:post
     * params:{ids:111,222}
     */
    @RequestMapping("/reshelf")
    public SysResult reshelf(Long[] ids) {

        int status = 1;	//表示上架
        itemService.updateStatus(ids,status);
        return SysResult.success();
    }

    @RequestMapping("/delete")
    public SysResult delete(Long[] ids){
        itemService.deleteItem(ids);
        return SysResult.success();
    }
}
