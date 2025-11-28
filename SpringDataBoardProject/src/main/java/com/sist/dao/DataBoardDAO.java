package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.DataBoardMapper;
import com.sist.vo.DataBoardVO;

@Repository
public class DataBoardDAO{
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> databoardListData(int start) {
		return mapper.databoardListData(start);
	}

	public void databoardInsert(DataBoardVO vo) {
		mapper.databoardInsert(vo);
	}
	
	public int databoardRowCount()
	{
		return mapper.databoardRowCount();
	}
	
	public DataBoardVO databoardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}

	public DataBoardVO databoardFileInfoData(int no)
	{
		return mapper.databoardDetailData(no);
	}
	public String databoardGetPassword(int no)
	{
		return mapper.databoardGetPassword(no);
	}
	
	public void databoardDelete(int no)
	{
		mapper.databoardDelete(no);
	}
	
	public DataBoardVO databoardUpdateData(int no)
	{
		return mapper.databoardDetailData(no);
	}
	
	public void databoardUpdate(DataBoardVO vo)
	{
		mapper.databoardUpdate(vo);
	}
}
