package com.sist.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sist.service.MemberService;
import com.sist.vo.MemberVO;

@RestController
public class MemberRestController {
	@Autowired
	private MemberService mService;
	
	@PostMapping("member/join_vue_ok.do")
	public ResponseEntity<Map> member_insert_vue(@RequestBody MemberVO vo)
	{
		Map map = new HashMap();
		
		try {
			mService.memberInsert(vo);
			map.put("msg", "yes");
		} catch (Exception e) {
			map.put("msg", "no");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
