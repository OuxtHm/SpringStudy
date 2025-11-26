package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.RecipeVO;

public interface RecipeMapper {
	@Select("SELECT no, title, chef "
			+ "FROM recipe "
			+ "WHERE ${column} LIKE'%'||#{ss}||'%'")
	public List<RecipeVO> recipeListData(Map map);
	
	@Select("SELECT COUNT(*) "
			+ "FROM recipe "
			+ "WHERE ${column} LIKE'%'||#{ss}||'%'")
	public int recipeFindCount(Map map);
}
