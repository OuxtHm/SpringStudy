package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.FoodVO;

/*
	클라이언트 ===== Service ==== DAO ===== 오라클
								|
								수정
*/
public interface FoodService {
	public List<FoodVO> foodListData(int start, int end);
	
	public int foodTotalPage();
	
	public FoodVO foodDetailData(int fno);
	public FoodVO foodCookieData(int fno);
	
	public List<FoodVO> foodFindData(Map map);
	public int foodFindTotalPage(String address);
	
}
