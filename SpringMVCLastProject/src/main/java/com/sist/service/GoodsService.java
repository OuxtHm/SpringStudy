package com.sist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.vo.GoodsVO;

public interface GoodsService {
	
	public List<GoodsVO> goodsListData(int start, int end);
	
	public int goodsTotalPage();
	
	public GoodsVO goodsDetailData(int no);
}
