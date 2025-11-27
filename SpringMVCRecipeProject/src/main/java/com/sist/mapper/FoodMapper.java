package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface FoodMapper {
	@Select("SELECT fno, name, poster, address num "
			+ "FROM (SELECT fno, name, poster, address rownum as num "
			+ "FROM (SELECT fno, name, poster, address "
			+ "FROM menupan_food ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*) / 12.0) FROM menupan_food")
	public int foodTotalPage();
	
	// 검색
	@Select("SELECT fno, name, poster, address, num "
	        + "FROM (SELECT fno, name, poster, address, rownum as num "
	        + "FROM (SELECT fno, name, poster, address "
	        + "FROM menupan_food WHERE address LIKE '%'||#{fd}||'%' ORDER BY fno ASC)) " // WHERE절 위치 수정 및 괄호 제거
	        + "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*) / 12.0) FROM menupan_food "
			+ "WHERE address LIKE'%'||#{fd}||'%' ")
	public int foodFindTotalPage(Map map);
	
	
}
 