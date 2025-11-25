package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;

@Service	// 비밀번호 암호화 / Session 저장 / 자도 로그인
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDAO eDao;
	
	@Autowired
	private DeptDAO dDao;
	
	
	@Override
	public List<DeptVO> deptListData() {
		// TODO Auto-generated method stub
		return dDao.deptListData();
	}

	@Override
	public List<EmpVO> empListData() {
		// TODO Auto-generated method stub
		return eDao.empListData();
	}

	@Override
	public EmpVO empDetailData(int empno) {
		// TODO Auto-generated method stub
		return eDao.empDetailData(empno);
	}
	
}
