package com.sist.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.*;
import com.sist.vo.*;
public interface RecipeMapper {
	@Select("SELECT no, title, chef, poster, num "
			+ "FROM (SELECT no, title, chef, poster, rownum as num "
			+ "FROM (SELECT no, title, chef, poster "
			+ "FROM recipe ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*) / 12.0) FROM recipe")
	public int recipeTotalPage();
	
}
