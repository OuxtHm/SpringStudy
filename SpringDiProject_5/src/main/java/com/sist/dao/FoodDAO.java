package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

public class FoodDAO {
	private FoodMapper mapper;
	// 구현된 클래스를 스프링을 통해 전송 => setter
	public void setMapper(FoodMapper mapper) {
			this.mapper = mapper;
		}

	/*	
@Select("SELECT fno, name, type, address, num "
			+ "FROM (SELECT fno, name, type, address, rownum as num "
			+ "FROM (SELECT fno, name, type, address "
			+ "FROM menupan_food ORDER BY fno)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);		
*/
	public List<FoodVO> foodListData(int start, int end)
	{
		return mapper.foodListData(start, end);
	}
}