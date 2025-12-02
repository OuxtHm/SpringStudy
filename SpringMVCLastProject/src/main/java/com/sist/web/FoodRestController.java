package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import com.sist.vo.*;
// 실제 데이터 전송
/*
	DAO : 데이터베이스만 연동
	VO : 데이터 베이스에 있는 값을 받아서 브라우저 전송 시 데이터를 묶어서 전송
	Service : DAO 여러개를 묶어서 한 번에 처리
					-> 기타 처리
					-> 비밀번호 암호화 / 복호화
					-> 비밀번호 확인
	Controller : JSP를 제어
					=> forward / redirect : 파일 변경
					=> front : router
	RestController	: 자바스크립트 연동 : JSON / 문자열 전송
	-------------------------------------------------
		서버로서의 역할만 수행
		
*/
@RestController
@CrossOrigin(origins="*")	// vue:8081 or react:3000에서 사용 가능
public class FoodRestController {
	// 스프링에 등록된 클래스 중에 필요한 클래스 가지고 오기 @Autowired
	@Autowired
	private FoodService fService;
	
	@GetMapping(value="food/list_vue.do", produces="text/plain;charset=UTF-8")
	public String food_list_vue(int page)
	{
		String result = "";
		Map map = new HashMap();
		final int ROWSIZE = 12;
		int start = (ROWSIZE * page) - (ROWSIZE - 1);
		int end = (ROWSIZE * page); 
				
		List<FoodVO> list = fService.foodListData(start, end);
		int totalpage = fService.foodTotalPage();
		
		// 블록별
		final int BLOCK = 10;
		int startPage= ((page -1) / BLOCK * BLOCK) + 1;
		int endPage = ((page -1) / BLOCK * BLOCK) + BLOCK;
		
		if(endPage > totalpage)
			endPage = totalpage;
		
		// JavaScript 전송
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; 
	}
	
	@GetMapping(value="food/detail_vue.do", produces="text/plain;charset=UTF-8")
	public String food_detail_vue(int fno)
	{
		String result = "";
		FoodVO vo = fService.foodDetailData(fno);
		try {
			ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(vo);
			// jackson : 객체 변환 객체 = JSON
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// DI / AOP / MVC / Transaction (MyBatis, JPA)
	// Security
	@GetMapping(value="food/find_vue.do", produces="text/plain;charset=UTF-8")
	public String food_find(int page, String address)
	{
		String result="";
		
		if(address == null)
			address = "마포";
		
		Map map = new HashMap();
		final int ROWSIZE = 12;
		int start = (ROWSIZE * page) - (ROWSIZE - 1);
		int end = (ROWSIZE * page); 
				
		map.put("start", start);
		map.put("end", end);
		map.put("address", address);
		
		List<FoodVO> list = fService.foodFindData(map);
		int totalpage = fService.foodFindTotalPage(address);
		
		// 블록별
		final int BLOCK = 10;
		int startPage= ((page -1) / BLOCK * BLOCK) + 1;
		int endPage = ((page -1) / BLOCK * BLOCK) + BLOCK;
		
		if(endPage > totalpage)
			endPage = totalpage;
		
		// JavaScript 전송
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("address", address);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
}
