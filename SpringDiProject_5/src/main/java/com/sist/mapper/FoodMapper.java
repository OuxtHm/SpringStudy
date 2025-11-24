package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;
public interface FoodMapper {
	/*
		@Insert <insert>
		@Update	<update>
		@Delete	<delete>
		@Results	<resultMap>
		@Selectkey
	*/
	@Select("SELECT fno, name, type, address, num "
			+ "FROM (SELECT fno, name, type, address, rownum as num "
			+ "FROM (SELECT fno, name, type, address "
			+ "FROM menupan_food ORDER BY fno)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
}
