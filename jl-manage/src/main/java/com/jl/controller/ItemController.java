package com.jl.controller;

import com.jl.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	
	
}
