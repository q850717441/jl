package com.jl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/page/{moduleName}")
	public String item_add(@PathVariable String moduleName) {
		return moduleName;
	}
	
	
	
	
	/**
	 * restFul风格:
	 *  	用户请求地址尽可能不变,只改变请求的类型,
	 *  从而实现请求的操作.
	 *  
	 *  url:localhost/user type:post   增
	 *  url:localhost/user type:put    改
	 *  url:localhost/user type:delete 删
	 *  url:localhost/user type:get    查
	 */
	
}
