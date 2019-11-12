package com.jl.service;


import com.jl.pojo.Item;
import com.jl.pojo.ItemDesc;
import com.jl.vo.EasyUITable;

public interface ItemService {

	EasyUITable findItemByPage(Integer page, Integer rows);

	void saveItem(Item item, ItemDesc itemDesc);

	void updateItem(Item item, ItemDesc itemDesc);

	void updateStatus(Long[] ids, Integer status);

	void deleteItem(Long[] ids);

	ItemDesc findItemDescById(Long itemId);

    Item findItemById(Long itemId);
}
