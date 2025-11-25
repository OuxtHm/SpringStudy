package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface StudentMapper {
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
	
	
}
