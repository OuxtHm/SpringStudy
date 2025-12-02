package com.sist.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//router
@Controller
public class FoodController {
	/*
		매개 변수 => 사용자가 보내준 데이터 설정
					page => int page / String page
					fd(검색어) => String fd
					checkbox => Stirng[]
					a[0], a[1], a[2] => List a
					=> VO (커맨드 객체)
				클래스 객체
					HttpServletResposne 
					HttpServletRequest
					RedirectAttribures
					HttpSession
					Model 
					
				=> 순서는 상관 없다
	*/
	@GetMapping("food/detail_before.do")
	public String food_detail_before(int fno, HttpServletResponse response, RedirectAttributes ra, HttpServletRequest request)
	{
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
		{
			for(int i = 0; i < cookies.length; i++)
			{
				if(cookies[i].getName().equals("food_" + fno))
				{
					cookies[i].setPath("/");
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
					break;
				}
			}
		}
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
