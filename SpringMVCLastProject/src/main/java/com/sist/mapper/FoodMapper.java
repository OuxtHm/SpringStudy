package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.FoodVO;

public interface FoodMapper {

	@Select("SELECT fno, name, poster, num "
			+ "FROM (SELECT fno, name, poster, rownum as num "
			+ "FROM (SELECT fno, name, poster "
			+ "FROM menupan_food ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*) / 12.0) FROM menupan_food")
	public int foodTotalPage();
	
	// 상세보기
	@Update("UPDATE menupan_food SET "
			+ "hit=hit+1 "
			+ "WHERE fno=#{fno}")
	public void hitIncrement(int fno);
	
	@Select("SELECT fno, name, poster, images, address, phone, parking, time, type, score, theme, context, price, likecount "
			+ "FROM menupan_food "
			+ "WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	
	// 검색
	@Select("SELECT fno, name, poster, num "
			+ "FROM (SELECT fno, name, poster, rownum as num "
			+ "FROM (SELECT fno, name, poster "
			+ "FROM menupan_food "
			+ "WHERE REGEXP_LIKE(address, #{address}) "
			+ "ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*) / 12.0) FROM menupan_food "
			+ "WHERE REGEXP_LIKE(address, #{address}) ")
	public int foodFindTotalPage(String address);
	
	
	// 카테고리별
	@Select("SELECT fno, name, poster, type, num "
			+ "FROM (SELECT fno, name, poster, type,  rownum as num "
			+ "FROM (SELECT fno, name, poster, type  "
			+ "FROM menupan_food "
			+ "WHERE REGEXP_LIKE(type, #{type}) "
			+ "ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodTypeData(Map map);
	
	@Select("SELECT CEIL(COUNT(*) / 12.0) FROM menupan_food "
			+ "WHERE REGEXP_LIKE(type, #{type}) ")
	public int foodTypeTotalPage(String type);
	
	
}
