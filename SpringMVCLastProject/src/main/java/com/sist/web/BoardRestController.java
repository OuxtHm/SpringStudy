package com.sist.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sist.service.BoardService;
import com.sist.vo.BoardVO;

@RestController
@CrossOrigin(origins="*")
public class BoardRestController {
	@Autowired
	private BoardService bService;
	
	@GetMapping("board/list_vue.do")
	// ResponseEntity<Map> ==> 반드시 비동기 처리 async
	public ResponseEntity<Map> board_list(int page)
	{
		Map map = new HashMap();
		
		try {
			int rowSize = 10;
			int start=(page - 1) * rowSize;
			int end = rowSize * page;
			map.put("start", start);
			map.put("end", end);
			
			List<BoardVO> list = bService.boardListData(start, end);
			int count = bService.boardRowCount();
			int totalpage = (int)(Math.ceil(count / 10.0));
			
			map = new HashMap();	// 전송 
			
			map.put("list", list);
			map.put("totalpage", totalpage);
			map.put("curpage", page);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	
	
	@PostMapping("board/insert_vue.do")
	public ResponseEntity<Map> board_insert(@RequestBody BoardVO vo)
	{
		Map map = new HashMap();
		try {
			bService.boardInsert(vo);
			map.put("msg", "yes");
			
		} catch (Exception e) {
			map.put("msg", "no");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	
	
	
}
