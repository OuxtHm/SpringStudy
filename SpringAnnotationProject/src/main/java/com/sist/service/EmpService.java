package com.sist.service;

import java.util.List;

import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

public interface EmpService {
	public List<DeptVO> deptListData();
	public List<EmpVO> empListData();
	public EmpVO empDetailData(int empno);
}
