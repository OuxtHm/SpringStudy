package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
import com.sist.vo.StudentVO;
// Spring  => 메모리 할당을 안 한다 :  Mapper / VO

@Repository
public class StudentDAO {

	@Autowired	// getBean
	private StudentMapper mapper;	// 구현된 크랠스를 대입 요청
	/*	
		// insert
	@SelectKey(keyProperty = "hakbun", resultType = int.class, before= true, statement="SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student")
	@Insert("INSERT INTO student VALUES(#{hakbun}, #{name}, #{kor}, #{eng}, #{math}) ")
	public void studentInsert(StudentVO vo);
	
	// select
	@Select("SELECT * FROM student ORDER BY hakbun ")
	public List<StudentVO> studentListData();
	
	// update
	@Update("UPDATE student SET "
			+ "kor=#{kor}, eng=#{eng}, math=#{math} "
			+ "WHERE hakbun =#{hakbun}")
	public void studentUpdate(StudentVO vo);
	
	// select(상세)
	@Select("SELECT * FROM student WHERE hakbun =#{hakbun}")
	public StudentVO studentDetailData(int haknbun);
	
	// delete
	@Delete("DELETE FROM student WHERE hakbun=#{hakbun}")
	public void studentDelete(int hakbun);
	 */
	
	public void studentInsert(StudentVO vo)
	{
		mapper.studentInsert(vo);
		
	}
	
	public List<StudentVO> studentListData()
	{
		
		return mapper.studentListData();
	}
	
	public void studentUpdate(StudentVO vo)
	{
		mapper.studentUpdate(vo);
	}
	
	public StudentVO studentDetailData(int hakbun)
	{
		
		return mapper.studentDetailData(hakbun);
	}
	
	public void studentDelete(int hakbun)
	{
		
		mapper.studentDelete(hakbun);
	}

}
