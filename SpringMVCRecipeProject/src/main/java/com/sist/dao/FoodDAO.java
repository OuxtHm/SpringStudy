package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
/*
	@Select("SELECT fno, name, poster, num "
			+ "FROM (SELECT fno, name, poster rownum as num "
			+ "FROM (SELECT fno, name, poster "
			+ "FROM menupan_food ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*) / 12.0) FROM menupan_food")
	public int foodTotalPage();							
*/
	
	public List<FoodVO> foodListData(int start, int end)
	{
		return mapper.foodListData(start, end);
	}
	
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
	
	/*
	@Select("SELECT fno, name, poster, num "
			+ "FROM (SELECT fno, name, poster, rownum as num "
			+ "FROM (SELECT fno, name, poster "
			+ "FROM menupan_food (SELECT ${column} LIKE '%'||#{fd}||'%' "
			+ "ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*) / 12.0) FROM menupan_food "
			+ "WHERE ${column} LIKE'%'||#{fd}||'%' ")
	public int foodFindTotalPage(Map map);
	*/	
	
	public List<FoodVO> foodFindData(Map map)
	{
		return mapper.foodFindData(map);
	}
	
	
	public int foodFindTotalPage(Map map)
	{
		return mapper.foodFindTotalPage(map);
	}
	
	
	
	
	
	
}
