package com.sist.service;

import java.util.List;

import com.sist.vo.StudentVO;

public interface StudentService {
	public void studentInsert(StudentVO vo);
	
	public List<StudentVO> studentListData();
	
	public void studentUpdate(StudentVO vo);
	
	public StudentVO studentDetailData(int hakbun);
	
	public void studentDelete(int hakbun);
}
