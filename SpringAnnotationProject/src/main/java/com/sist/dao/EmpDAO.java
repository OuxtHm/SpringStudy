package com.sist.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.EmpMapper;
import com.sist.vo.EmpVO;

@Repository
public class EmpDAO {
	@Autowired	// 스프링 안에서 메모리 할당된 클래스만 적용이 가능
	private EmpMapper mapper;
	
	/*
	@Select("SELECT empno, ename, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday "
			+ "FROM emp ORDER BY empno")
	public List<EmpVO> empListData();
	*/
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}

	/*
	@Select("SELECT empno, ename, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday, dname, loc "
			+ "FROM emp, dept "
			+ "WHERE emp.deptno = dept.deptno "
			+ "AND empno = #{empno}")
	public EmpVO empDetailData(int empno);
	*/
	public EmpVO empDetailData(int empno)
	{
		return mapper.empDetailData(empno);
	}
}
