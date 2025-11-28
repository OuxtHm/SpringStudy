package com.sist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.vo.DataBoardVO;


public interface DataBoardService {
	public List<DataBoardVO> databoardListData(int start);

	public void databoardInsert(DataBoardVO vo);
	public int databoardRowCount();
	public DataBoardVO databoardDetailData(int no);
	
	public DataBoardVO databoardFileInfoData(int no);
	public boolean databoardDelete(int no, String pwd);
	
	public DataBoardVO databoardUpdateData(int no);
	public boolean databoardUpdate(DataBoardVO vo);
}
