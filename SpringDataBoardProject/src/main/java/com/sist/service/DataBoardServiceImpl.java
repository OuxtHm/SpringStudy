package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.DataBoardDAO;
import com.sist.vo.DataBoardVO;

@Service
public class DataBoardServiceImpl implements DataBoardService{
	@Autowired
	private DataBoardDAO dao;
	
	@Override
	public List<DataBoardVO> databoardListData(int start) {
		return dao.databoardListData(start);
	}

	@Override
	public void databoardInsert(DataBoardVO vo) {
		dao.databoardInsert(vo);		
	}

	@Override
	public int databoardRowCount()
	{
		return dao.databoardRowCount();
	}
	
	@Override
	public DataBoardVO databoardDetailData(int no)
	{
		return dao.databoardDetailData(no);
	}
	
	@Override
	public boolean databoardDelete(int no, String pwd) {
		boolean bCheck = false;
		
		String db_pwd = dao.databoardGetPassword(no);
		if(db_pwd.equals(pwd))
		{
			bCheck = true;
			dao.databoardDelete(no);
		}
		
		return bCheck;
	}
	
	@Override
	public DataBoardVO databoardFileInfoData(int no) {
		return dao.databoardFileInfoData(no);
	}
	
	
	@Override
	public DataBoardVO databoardUpdateData(int no) {
		return dao.databoardUpdateData(no);
	}
	
	
	@Override
	public boolean databoardUpdate(DataBoardVO vo) {
		boolean bCheck = false;
		
		String db_pwd = dao.databoardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			bCheck = true;
			dao.databoardUpdate(vo);
		}
		
		return bCheck;
	}
}
