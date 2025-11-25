package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.StudentDAO;
import com.sist.vo.StudentVO;

// MainClass => StudentService => StudentServceImpl => studentDAO

@Service("service")
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO sDao;
	
	@Override
	public void studentInsert(StudentVO vo) {
		sDao.studentInsert(vo);
	}

	@Override
	public List<StudentVO> studentListData() {
		return sDao.studentListData();
	}

	@Override
	public void studentUpdate(StudentVO vo) {
		sDao.studentUpdate(vo);
	}

	@Override
	public StudentVO studentDetailData(int hakbun) {
		return sDao.studentDetailData(hakbun);
	}

	@Override
	public void studentDelete(int hakbun) {
		sDao.studentDelete(hakbun);
	}
	
}
