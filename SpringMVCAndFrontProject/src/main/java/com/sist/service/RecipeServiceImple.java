package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.RecipeDAO;
import com.sist.vo.RecipeVO;

@Service
public class RecipeServiceImple implements RecipeService{
	@Autowired
	private RecipeDAO rDao;
	
	@Override
	public List<RecipeVO> recipeListData(int start, int end)
	{
		return rDao.recipeListData(start, end);
	}
	
	@Override
	public int recipeTotalPage()
	{
		return rDao.recipeTotalPage();
	}

	@Override
	public List<RecipeVO> recipeFindData(Map map) {
		return rDao.recipeFindData(map);
	}

	@Override
	public int recipeFindTotalPage(Map map) {
		return rDao.recipeFindTotalPage(map);
	}
	
	
	
}
