package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO bDao;
	
	@Override
	public List<BoardVO> boardListData(int start, int end) {
		return bDao.boardListData(start, end);
	}
	
	@Override
	public int boardRowCount() {
		return bDao.boardRowCount();
	}
	
	@Override
	public void boardInsert(BoardVO vo) {
		bDao.boardInsert(vo);		
	}
}
