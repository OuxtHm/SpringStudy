package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsDAO gDao;

	@Override
	public List<GoodsVO> goodsListData(int start, int end) {
		return gDao.goodsListData(start, end);
	}

	@Override
	public int goodsTotalPage() {
		return gDao.goodsTotalPage();
	}

	@Override
	public GoodsVO goodsDetailData(int no) {
		return gDao.goodsDetailData(no);
	}
	
	
	
}
