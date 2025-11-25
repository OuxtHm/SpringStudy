package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.EmpVO;
public interface EmpMapper {
	@Select("SELECT empno, ename, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday "
			+ "FROM emp ORDER BY empno")
	public List<EmpVO> empListData();
	
	@Results({
		@Result(property = "dvo.dname", column = "dname"),
		@Result(property = "dvo.loc", column = "loc")
	})
	@Select("SELECT empno, ename, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday, dname, loc "
			+ "FROM emp, dept "
			+ "WHERE emp.deptno = dept.deptno "
			+ "AND empno = #{empno}")
	public EmpVO empDetailData(int empno);
}
