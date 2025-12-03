package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GoodsController {
	@GetMapping("goods/list.do")
	public String goods_list(Model model)	// router
	{
		
		model.addAttribute("main_jsp", "../goods/list.jsp");
		return "main/main";
	}
	
	@GetMapping("goods/detail.do")
	public String goods_detail(Model model, int no)
	{
		model.addAttribute("no", no);
		model.addAttribute("main_jsp", "../goods/detail.jsp");
		return "main/main";
	}
}
