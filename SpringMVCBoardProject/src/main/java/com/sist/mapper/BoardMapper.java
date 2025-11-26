package com.sist.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;
import com.sist.vo.*;
public interface BoardMapper {
	
	@Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit, num "
			+ "FROM (SELECT no, subject, name, regdate, hit, rownum as num "
			+ "FROM (SELECT no, subject, name, regdate, hit "
			+ "FROM springBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*) / 10.0) FROM springBoard")
	public int boardTotalPage();
	
	@Insert("INSERT INTO springBoard(no, name, subject, content, pwd) "
			+ "VALUES(sb_no_seq.nextval, #{name}, #{subject}, #{content}, #{pwd})")
	public void boardInsert(BoardVO vo);
	
	@Update("UPDATE springBoard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no, name, subject, content, hit, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') as dbday "
			+ "FROM springBoard WHERE no=#{no}")
	public BoardVO boardDetail(int no);
	
	
	@Select("SELECT pwd FROM springBoard WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	@Delete("DELETE FROM springBoard WHERE no=#{no} ")
	public void boardDelete(int no);
	
	
	@Update("UPDATE springBoard SET name=#{name}, subject=#{subject}, content=#{content} "
			+ "WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
}
