package com.sist.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.RecipeService;
import com.sist.vo.EmpVO;
import com.sist.vo.RecipeVO;

// 화면 제어 x  => Front로 데이터 전송
// 1. 일반 문자열 2. 정수 3. JSON
// => JSON을 자동으로 구현
@RestController
public class RestRecipeController {
	@Autowired
	private RecipeService service;
	
	@GetMapping(value="recipe/list_vue.do", produces="text/plain;charset=UTF-8")
	public String recipe_list_vue(int page) throws Exception
	{
		int curpage=page;
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize -1);
		int end=rowSize * curpage;
		
		List<RecipeVO> list = service.recipeListData(start, end);
		
		int totalpage = service.recipeTotalPage();
		
		final int BLOCK = 10;
		int startpage = ((curpage-1) / BLOCK * BLOCK) + 1;
		int endpage = ((curpage-1) / BLOCK * BLOCK) + BLOCK;
		
		if(endpage > totalpage)
			endpage = totalpage;
		
		Map map = new HashMap();
		map.put("curpage", curpage);
		map.put("totalpage", totalpage);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("list", list);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		return json;
	}
	
}
