package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodDAO fDao;
	
	@Override
	public List<FoodVO> foodFindData(Map map) {
		return fDao.foodFindData(map);
	}

	@Override
	public int foodFindTotalPage(Map map) {
		return fDao.foodFindTotalPage(map);
	}
	
}
