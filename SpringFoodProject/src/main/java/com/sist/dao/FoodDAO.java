package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.FoodVO;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
/*	
@Select("SELECT fno, name, address, type, phone "
			+ "FROM menupan_food "
			+ "WHERE ${column} LIKE'%'||#{ss}||'%'")
	public List<FoodVO> foodFindData(Map map);
	
	@Select("SELECT COUNT(*) "
			+ "FROM menupan_food "
			+ "WHERE ${column} LIKE'%'||#{ss}||'%'")
	public int foodFindCount(Map map);
*/
	public List<FoodVO> foodFindData(Map map)
	{
		return mapper.foodFindData(map);
	}
	
	public int foodFindCount(Map map)
	{
		return mapper.foodFindCount(map);
	}
}
