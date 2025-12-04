package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO mDao;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public void memberInsert(MemberVO vo) {
		String enPwd = encoder.encode(vo.getUserpwd());
		vo.setUserpwd(enPwd);
		mDao.memberInsert(vo);		
	}
}
