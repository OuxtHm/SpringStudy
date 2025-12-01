package com.sist.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//router
@Controller
public class FoodController {
	@GetMapping("food/detail_before.do")
	public String food_detail_before(int fno, HttpServletResponse response, RedirectAttributes ra)
	{
		Cookie cookie = new Cookie("food_" + fno, String.valueOf(fno));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		ra.addAttribute("fno", fno);
		return "redirect:detail.do";
	}
	
	@GetMapping("food/detail.do")
	public String food_detail(int fno, Model model)
	{
		model.addAttribute("fno", fno);
		model.addAttribute("main_jsp", "../food/detail.jsp");
		
		return "main/main";
	}
	
	@GetMapping("food/find.do")
	public String food_find(Model model)
	{
		model.addAttribute("main_jsp", "../food/find.jsp");
		return "main/main";
	}
}
