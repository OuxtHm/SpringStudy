package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BoardMapper;
import com.sist.vo.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	private BoardMapper mapper;
/*
@Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit, num "
			+ "FROM (SELECT no, subject, name, regdate, hit, rownum as num "
			+ "FROM (SELECT no, subject, name, regdate, hit "
			+ "FROM springBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*) / 10.0 FROM springBoard")
	public int boardTotalPage();
	
	@Insert("INSERT INTO springBoard(no, name, subejct, content, pwd) "
			+ "VALUES(sb_no_seq.nextval, #{name}, #{subject}, #{content}, #{pwd}")
	public void boardInsert(BoardVO vo);
*/
	public List<BoardVO> boardListData(int start, int end)
	{
		return mapper.boardListData(start, end);
	}
	
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
/*	
	@Update("UPDATE springBoard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	
	@Select("SELECT no, name, subject, content, hit, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') as dbday "
			+ "FROM springBoard WHERE no=#{no}")
	public BoardVO boardDetail(int no);		
	
*/
	public BoardVO boardDetail(int no)
	{
		mapper.hitIncrement(no);
		return mapper.boardDetail(no);
	}
	
/*
	@Select("SELECT pwd FROM springBoard WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	@Delete("DELETE FROM springBoard WHERE no=#{no} ")
	public void boardDelete(int no);
*/
	public String boardDelete(int no, String pwd)
	{
		String db_pwd = mapper.boardGetPassword(no);
		String res = "";
		
		if(db_pwd.equals(pwd))
		{
			res = "yes";
			mapper.boardDelete(no);
		}
		
		return res;
	}
	
	public BoardVO boardUpdateDate(int no)
	{
		return mapper.boardDetail(no);
	}
	
/*	
	@Update("UPDATE springBoard SET name=#{name}, subject=#{subject}, content=#{content} "
			+ "WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);	
*/
	public boolean boardUpdate(BoardVO vo)
	{
		boolean res = false;
		String db_pwd = mapper.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			res = true;
			mapper.boardUpdate(vo);
		}
		return res;
	}
}
