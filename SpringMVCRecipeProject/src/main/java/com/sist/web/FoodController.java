package com.sist.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.FoodDAO;
import com.sist.service.FoodService;
import com.sist.vo.FoodVO;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	@Autowired
	private FoodService service;
	
	@GetMapping("food/list.do")
	public String food_list(String page, Model model)
	{
		if(page == null)
			page = "1";
		
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (rowSize * curpage) - (rowSize - 1);
		int end = rowSize * curpage;
		
		List<FoodVO> list = dao.foodListData(start, end);
		int totalpage = dao.foodTotalPage();
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		
		return "food/list";
	}
	
	@RequestMapping("food/find.do")
	public String food_find(String page, String fd, Model model)
	{
		if(page == null)
			page = "1";
		if(fd == null)
			fd = "마포";
		int curpage = Integer.parseInt(page);
		
		Map map = new HashMap();
		map.put("fd", fd);
		map.put("start", (curpage * 12) - 11);
		map.put("end", curpage * 12);
		
		List<FoodVO> list = service.foodFindData(map);
		
		int totalpage = service.foodFindTotalPage(map);
		
		// 블록별 처리
		final int BLOCK = 10;
		int startpage = ((curpage - 1) / BLOCK * BLOCK) + 1;
		int endpage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;
		
		if(endpage > totalpage)
			endpage = totalpage;
		
		// JSP 전송
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		model.addAttribute("list", list);
		model.addAttribute("fd", fd);
		
		
		return "food/find";
	}
}
