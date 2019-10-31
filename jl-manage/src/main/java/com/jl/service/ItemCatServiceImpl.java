package com.jl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jl.mapper.ItemCatMapper;
import com.jl.pojo.ItemCat;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	@Autowired
	private ItemCatMapper itemCatMapper;

	@Override
	public ItemCat findItemCatById(Long itemCatId) {
		
		return itemCatMapper.selectById(itemCatId);
	}
}
