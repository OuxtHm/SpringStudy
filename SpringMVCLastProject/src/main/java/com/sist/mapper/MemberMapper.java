package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.sist.vo.MemberVO;

public interface MemberMapper {
	@Insert("INSERT INTO springMember VALUES("
			+ "#{userid}, #{userpwd}, #{username}, #{sex}, 1, 'ROLE_MEMBER') ")
	public void memberInsert(MemberVO vo);
}
