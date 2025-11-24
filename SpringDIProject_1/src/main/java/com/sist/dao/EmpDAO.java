package com.sist.dao;

import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

public class EmpDAO {
	private EmpMapper mapper;
	
	public void setMapper(EmpMapper mapper)
	{
		this.mapper = mapper;
	}
	
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
	
	public EmpVO empDetailData(int empno)
	{
		return mapper.empDetailData(empno);
	}
}
