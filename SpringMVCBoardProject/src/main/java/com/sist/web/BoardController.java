package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
@RequestMapping("board/")
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("list.do")
	public String board_list(String page, Model model)
	{
		if(page == null)
			page = "1";
		// @@@@@@@@@@@@@@@@@@@@@@
		int curpage = Integer.parseInt(page);
		int rowSize = 10;
		int start = (rowSize * curpage) - (rowSize - 1);
		int end = rowSize * curpage;
			
		List<BoardVO> list = dao.boardListData(start, end);
		int totalpage = dao.boardTotalPage();
		// @@@@@@@@@@@@@@@@@@@@@@ 요청 처리
		
		// 결과값 전송
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage",  totalpage);
		
		return "board/list";
	}
	
	@GetMapping("insert.do")
	public String board_insert()
	{
		return "board/insert";
	}
	
	@PostMapping("insert_ok.do")
	public String board_insert_ok(BoardVO vo)
	{
		dao.boardInsert(vo);
		return "redirect:list.do";
	}
	
	@GetMapping("detail.do")
	public String board_detail(int no, Model model)
	{
		BoardVO vo = dao.boardDetail(no);
		model.addAttribute("vo", vo);
		return "board/detail";
	}
	
	
	// 수정
	@GetMapping("update.do")
	public String board_update(int no, Model model)
	{
		BoardVO vo = dao.boardUpdateDate(no);
		model.addAttribute("vo", vo);
		return "board/update";
	}
	
	// 삭제
}
