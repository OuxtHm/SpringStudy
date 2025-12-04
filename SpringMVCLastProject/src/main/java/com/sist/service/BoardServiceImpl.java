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
	
	@Override
	public BoardVO boardDetailData(int no) {
		return bDao.boardDetailData(no);
	}
	
	@Override
	public String boardDelete(int no, String pwd) {
		String result = "no";
		String db_pwd = bDao.boardGetPassword(no);
		if(db_pwd.equals(pwd))
		{
			result = "yes";
			bDao.boardDelete(no);
		}
		return result;
	}
	
	
	@Override
	public String boardUpdate(BoardVO vo) {
		String result = "no";
		
		String db_pwd = bDao.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			result = "yes";
			bDao.boardUpdate(vo);
		}
		return result;
	}
	@Override
	public BoardVO boardUpdateData(int no) {
		return bDao.boardUpdateData(no);
	}
	
	
}
