package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.vo.MemberVO;

@Controller
public class MainController {
	// 일반 화면
	@GetMapping("main/input.do")
	public String main_input()
	{
		return "main/input";
	}
	
	/*@PostMapping("main/input_ok.do")
	public String main_input_ok(HttpServletRequest request, HttpServletResponse response)
	{
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String content = request.getParameter("content");
		
		MemberVO vo = new MemberVO();
		
		vo.setName(name);
		vo.setSex(sex);
		vo.setAddress(address);
		vo.setContent(content);
		
		request.setAttribute("vo", vo);
		return "main/output";
	}*/
	
	@PostMapping("main/input_ok.do")
	public String main_input_ok(MemberVO vo, Model model)
	{
		// MemberVO vo => 커맨드 객체
		// Model model => 전송 객체
		model.addAttribute("vo", vo);
		
		return "main/output";
	}
}
