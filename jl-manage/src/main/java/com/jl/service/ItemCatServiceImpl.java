package com.jl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jl.mapper.ItemCatMapper;
import com.jl.pojo.ItemCat;
import com.jl.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	@Autowired
	private ItemCatMapper itemCatMapper;

	@Override
	public ItemCat findItemCatById(Long itemCatId) {
		
		return itemCatMapper.selectById(itemCatId);
	}
	
	
	/**
	 * 1.根据parentId查询数据库记录
	 * 2.循环遍历数据,之后封装EasyUITree的list集合
	 */
	@Override
	public List<EasyUITree> findItemCatByParentId(Long parentId) {
		//1.查询数据
		List<ItemCat> itemCatList = 
					  findItemCatListByParentId(parentId);
		//2.实现数据封装
		List<EasyUITree> treeList = 
				new ArrayList<EasyUITree>(itemCatList.size());
		for (ItemCat itemCat : itemCatList) {
			Long id = itemCat.getId();
			String text = itemCat.getName();
			//如果是父级 closed,否则 表示3级标题 open
			String state = itemCat.getIsParent()?"closed":"open";
			EasyUITree tree = new EasyUITree(id, text, state);
			treeList.add(tree);
		}
		
		return treeList;
	}

	private List<ItemCat> findItemCatListByParentId(Long parentId) {
		QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("parent_id", parentId);
		List<ItemCat> itemCatList = 
				itemCatMapper.selectList(queryWrapper);
		return itemCatList;
	}
	
	
	
	
	
	
	
	
	
}
