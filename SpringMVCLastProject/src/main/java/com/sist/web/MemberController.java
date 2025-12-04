package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	@Autowired
	private BCryptPasswordEncoder encoder;
	/*
	@GetMapping("member/join.do")
	public String member_join(String id, String pwd, Model model)
	{
		String enPwd = encoder.encode(pwd);
		System.out.println(enPwd);
		//model.addAttribute("id", id);
		//model.addAttribute("pwd", enPwd);
		return "member/join";
	}*/
	
	@GetMapping("member/join.do")
	public String member_join(Model model)
	{
		model.addAttribute("main_jsp", "../member/join.jsp");
		return "main/main";
	}
}
