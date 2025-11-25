package com.sist.mapper;

import java.util.*;
import org.apache.ibatis.annotations.Select;
import com.sist.vo.DeptVO;

/*
select * from dept order by deptno;
return형 -- List

select * from dept where deptno = 10;
return형 -- DeptVO

select loc from dept where deptno = 10;
return형 -- String

select loc from dept;
return형 -- List<String>

select deptno from dept;
return형 -- List<Integer>

*/
public interface DeptMapper {
	@Select("SELECT * FROM dept ORDER BY deptno ")
	public List<DeptVO> deptListData();
}
