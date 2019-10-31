package com.jl.service;

import com.jl.vo.EasyUITable;

public interface ItemService {

	EasyUITable findItemByPage(Integer page, Integer rows);
	
}
