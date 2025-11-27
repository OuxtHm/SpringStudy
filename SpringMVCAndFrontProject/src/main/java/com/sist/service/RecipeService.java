package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.RecipeVO;
// DAO여러개를 묶어서 사용이 가능
// 의존성이 약한 프로그램 => 다른 클래스에 영향이 없게
public interface RecipeService {
	public List<RecipeVO> recipeListData(int start, int end);
	
	public int recipeTotalPage();
	
	public List<RecipeVO> recipeFindData(Map map);
	
	public int recipeFindTotalPage(Map map);
}
