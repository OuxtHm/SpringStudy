package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.GoodsVO;

public interface GoodsMapper {
	@Select("SELECT no, goods_poster, goods_name, goods_price, num "
			+ "FROM (SELECT no, goods_poster, goods_name, goods_price, rownum as num "
			+ "FROM (SELECT no, goods_poster, goods_name, goods_price "
			+ "FROM good_all ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*) / 12.0) FROM good_all ")
	public int goodsTotalPage();
	
	@Select("SELECT * FROM good_all "
			+ "WHERE no=#{no} ")
	public GoodsVO goodsDetailData(int no);
}
