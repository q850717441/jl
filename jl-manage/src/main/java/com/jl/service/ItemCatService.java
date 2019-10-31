package com.jl.service;

import com.jl.pojo.ItemCat;
import com.jl.vo.EasyUITree;

import java.util.List;

public interface ItemCatService {

	ItemCat findItemCatById(Long itemCatId);

	List<EasyUITree> findItemCatByParentId(Long parentId);
}
