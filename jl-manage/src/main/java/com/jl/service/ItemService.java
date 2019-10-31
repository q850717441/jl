package com.jl.service;

import com.jl.pojo.Item;
import com.jl.vo.EasyUITable;

public interface ItemService {

	EasyUITable findItemByPage(Integer page, Integer rows);

	void saveItem(Item item);

	void updateItem(Item item);

	void updateStatus(Long[] ids, Integer status);

	void deleteItem(Long[] ids);
}
