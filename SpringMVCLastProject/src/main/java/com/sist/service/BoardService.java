package com.sist.service;

import java.util.List;

import com.sist.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> boardListData(int start, int end);
	
	public int boardRowCount();
	public void boardInsert(BoardVO vo);
	public BoardVO boardDetailData(int no);
	public String boardDelete(int no, String pwd);
	
	public String boardUpdate(BoardVO vo);
	public BoardVO boardUpdateData(int no);
}
