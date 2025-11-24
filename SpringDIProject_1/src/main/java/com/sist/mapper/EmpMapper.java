package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.EmpVO;

public interface EmpMapper {
	@Select("SELECT empno, ename, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday " 
			+ "FROM emp ORDER BY empno ASC")
	public List<EmpVO> empListData();
	
	/*
	 * @Select("SELECT empno, ename, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday "
	 * +"FROM emp WHERE empno=#{empno}")
	 */
	public EmpVO empDetailData(int empno);
}
