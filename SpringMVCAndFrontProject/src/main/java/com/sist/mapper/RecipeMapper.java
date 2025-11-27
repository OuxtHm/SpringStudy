package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
// 메소드 선언 => 자동 구현 (SQL) => JPA => @Query
public interface RecipeMapper {
   @Select("SELECT no,poster,title,chef,num "
         + "FROM (SELECT no,poster,title,chef,rownum as num "
         + "FROM (SELECT no,poster,title,chef "
         + "FROM recipe "
         + "WHERE no IN(SELECT no FROM recipe INTERSECT "
         + "SELECT no FROM recipeDetail) "
         + "ORDER BY no ASC)) "
         + "WHERE num BETWEEN #{start} AND #{end}")
   public List<RecipeVO> recipeListData(@Param("start") int start, @Param("end") int end);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
         + "WHERE no IN(SELECT no FROM recipe INTERSECT "
         + "SELECT no FROM recipeDetail)")
   public int recipeTotalPage();
   // => openSession(true) / session.close(), session.commit()
   // => 1. return형, 2. 매개변수
   
   // 검색
   @Select("SELECT no,poster,title,chef,num "
	         + "FROM (SELECT no,poster,title,chef,rownum as num "
	         + "FROM (SELECT no,poster,title,chef "
	         + "FROM recipe "
	         + "WHERE no IN(SELECT no FROM recipe INTERSECT "
	         + "SELECT no FROM recipeDetail) "
	         + "AND ${column} LIKE '%'||#{fd}||'%' "
	         + "ORDER BY no ASC)) "
	         + "WHERE num BETWEEN #{start} AND #{end}")
   public List<RecipeVO> recipeFindData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
	         + "WHERE no IN(SELECT no FROM recipe INTERSECT "
	         + "SELECT no FROM recipeDetail) AND ${column} LIKE '%'||#{fd}||'%' ")
   public int recipeFindTotalPage(Map map);
}
