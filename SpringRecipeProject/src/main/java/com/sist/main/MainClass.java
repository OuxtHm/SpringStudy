package com.sist.main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.service.RecipeService;
import com.sist.vo.RecipeVO;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("application-*.xml");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 카테고리를 선택하세요: (1. 레시피명, 2. 셰프)");
		
		String column = "";
		
		int categoryNum = scan.nextInt();
		String[] strColumn = {"",  "title", "chef"};
		System.out.print("검색어를 입력하세요: ");
		String ss = scan.next();
		
		Map map = new HashMap();
		map.put("column", strColumn[categoryNum]);
		map.put("ss", ss);
		
		RecipeService rs = (RecipeService)app.getBean("recipeServiceImpl");
		
		int count = rs.recipeFindCount(map);
		List<RecipeVO> list = rs.recipeListData(map);
		
		System.out.println("검색 결과: " + count + "건");
		for(RecipeVO vo : list)
		{
			System.out.println(vo.getTitle() + " " + vo.getChef());
		}
	}

}
