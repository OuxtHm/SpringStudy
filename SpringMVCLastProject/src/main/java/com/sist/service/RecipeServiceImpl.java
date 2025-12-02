package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.RecipeDAO;
import com.sist.vo.RecipeVO;

@Service
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private RecipeDAO rDao;
	
	@Override
	public int recipeCount() {
		return rDao.recipeCount();
	}
	@Override
	public List<RecipeVO> recipeListData(int start, int end) {
		return rDao.recipeListData(start, end);
	}
}
