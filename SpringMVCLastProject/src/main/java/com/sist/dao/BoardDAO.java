package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BoardMapper;
import com.sist.vo.BoardVO;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper bMapper;
	
/*	
@Select("SELECT no, name, subject, TO_CHAR(regdate,'YYYY-MM-DD') as dbday, num "
			+ "FROM (SELECT no, name, subject, regdate, hit, rownum as num "
			+ "FROM (SELECT no, name, subject, regdate, hit "
			+ "FROM springBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start") int start, @Param("end") int end);

	@Select("SELECT COUNT(*) FROM springBoard ")
	public int boardRowCount();		
*/
	public List<BoardVO> boardListData(int start, int end)
	{
		return bMapper.boardListData(start, end);
	}
	
	public int boardRowCount()
	{
		return bMapper.boardRowCount();
	}
	
/*
@Insert("INSERT INTO springBoard VALUES("
			+ "sb_no_seq.nextval,"
			+ "#{name}, #{subject}, #{content}, #{pwd}, SYSDATE, 0)")
	public void boardInsert(BoardVO vo);	
*/
	public void boardInsert(BoardVO vo)
	{
		bMapper.boardInsert(vo);
	}
	
/*	
@Update("UPDATE springBoard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void boardHitIncrement(int no);
	@Select("SELECT no, name, subject, content, hit, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') as dbday "
			+ "FROM springBoard "
			+ "WHERE no=#{no}")
	public BoardVO boardDetailData(int no);		
*/
	public BoardVO boardDetailData(int no)
	{
		bMapper.boardHitIncrement(no);
		return bMapper.boardDetailData(no);
	}
/*
	@Select("SELECT pwd FROM springBoard WHERE no=#{no}")
	public String boardGetPassword(int no);
	@Delete("DELETE springBoard WHERE #{no}")
	public void boardDelete(int no);	
*/
	public String boardGetPassword(int no)
	{
		return bMapper.boardGetPassword(no);
	}
	public void boardDelete(int no)
	{
		bMapper.boardDelete(no);
	}
	

	public void boardUpdate(BoardVO vo)
	{
		bMapper.boardUpdate(vo);
	}

	public BoardVO boardUpdateData(int no)
	{
		return bMapper.boardUpdateData(no);
	}
	
}
