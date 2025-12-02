package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.RecipeService;
import com.sist.vo.RecipeVO;

@Controller
public class RecipeController {
	@Autowired
	//@Qualifier("recipeServiceImpl")
	private RecipeService rService;
	
	@GetMapping("recipe/list.do")
	public String recipe_list_vue(String page, Model model)
	{
		if(page==null)
			page = "1";
		
		int curpage = Integer.parseInt(page);
		int rowSize= 12;
		int start = (rowSize * curpage) - (rowSize - 1);
		int end = (rowSize * curpage);
	
		List<RecipeVO> list = rService.recipeListData(start, end);
		
		int count = rService.recipeCount();
		int totalpage = (int)(Math.ceil(count/12.0));
		
		// 블록별 처리
		final int BLOCK = 10;
		
		int startPage = ((curpage - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;
		
		if(endPage > totalpage)
			endPage = totalpage;
		
		// 데이터 JSP로 전송 => Model
		model.addAttribute("list", list);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("main_jsp", "../recipe/list.jsp");
		return "main/main";
	}
}
