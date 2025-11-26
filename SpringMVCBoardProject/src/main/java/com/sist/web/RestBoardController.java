package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

// 자바스크립트로 데이터 전송할 때 사용
@RestController
public class RestBoardController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping(value="board/delete.do", produces = "text/plain;charset=UTF-8")
	public String board_delete(int no, String pwd)
	{
		String res = "";
		res = dao.boardDelete(no, pwd);
		return res;
	}
	
	@PostMapping(value="board/update_ok.do", produces = "text/html;charset=UTF-8")
	public String board_update(BoardVO vo)
	{
		String res="";
		boolean bCheck = dao.boardUpdate(vo);
		if(bCheck)
		{
			res = "<script> location.href=\"detail.do?no="+vo.getNo()+"\" </script>";
		}
		else
		{
			res = "<script>"
				+"alert(\"비밀번호가 틀립니다\");"
				+"history.back();"
				+"</script>";
				
		}
		return res;
	}
	
}
