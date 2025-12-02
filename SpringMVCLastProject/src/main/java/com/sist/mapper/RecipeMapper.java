package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.RecipeVO;

public interface RecipeMapper {
	@Select("SELECT no, title, poster, num "
			+ "FROM (SELECT no, title, poster, rownum as num "
			+ "FROM (SELECT no, title, poster "
			+ "FROM recipe WHERE no IN(SELECT no FROM recipe "
			+ "INTERSECT SELECT no FROM recipedetail)"
			+ "ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end} ")
	public List<RecipeVO> recipeListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT COUNT(*) FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe "
			+ "INTERSECT SELECT no FROM recipedetail)")
	public int recipeCount();
}
