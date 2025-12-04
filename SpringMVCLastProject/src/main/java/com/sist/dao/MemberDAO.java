package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MemberMapper;
import com.sist.vo.MemberVO;


@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
/*
@Insert("INSERT INTO springMember VALUES("
			+ "#{userid}, #{userpwd}, #{username}, #{sex}, 1, 'ROLE_MEMBER') ")
	public void memberInsert(MemberVO vo);	
*/	
	public void memberInsert(MemberVO vo)
	{
		mapper.memberInsert(vo);
	}
	
}
