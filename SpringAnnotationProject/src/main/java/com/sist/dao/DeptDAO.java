package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class DeptDAO {
	@Autowired
	private DeptMapper mapper;

	/*	
	@Select("SELECT * FROM dept ORDER BY deptno ")
	public List<DeptVO> deptListData();	
	*/
	public List<DeptVO> deptListData()
	{
		return mapper.deptListData();
	}
}
