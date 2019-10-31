package com.jl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jl.pojo.ItemCat;
import com.jl.service.ItemCatService;

@RestController
@RequestMapping("/item/cat")
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 根据itemCatId查询商品分类名称
	 * http://localhost:8091/item/cat/queryItemName?itemCatId=560
	 */
	@RequestMapping("/queryItemName")
	public String findItemCatNameById(Long itemCatId) {
		
		//1.先根据id查询对象
		ItemCat itemCat = 
				itemCatService.findItemCatById(itemCatId);
		//2.将对象中的name名称获取
		return itemCat.getName();
	}
}
