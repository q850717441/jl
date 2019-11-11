package com.jl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	/**
	 * 为了演示伪静态的作用添加该方法
	 */
	@RequestMapping("/index")
	public String index() {
		
		return "index";
	}
}
