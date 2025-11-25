package com.sist.main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.service.*;
import com.sist.vo.*;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("application-*.xml");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 카테고리를 선택: (1. 업체명, 2. 주소, 3. 음식종류)");
		String column = "";
		int cate = scan.nextInt();
		String[] strColumn = {"", "name", "address", "type"};
		System.out.print("검색어를 입력하세요: ");
		String ss = scan.next();
		
		Map map = new HashMap();
		map.put("column", strColumn[cate]);
		map.put("ss", ss);
		
		FoodService fs = (FoodService)app.getBean("foodServiceImpl");
		int count = fs.foodFindCount(map);
		List<FoodVO> list = fs.foodFindData(map);
		System.out.println("검색 결과 : " + count + "건");
		for(FoodVO vo : list)
		{
			System.out.println(vo.getName() + " "
								+ vo.getType());
		}
	}

}