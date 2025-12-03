package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import com.sist.vo.*;
// VueJS => 데이터 전송 
// RestFul : 다른 프로그램과 연동 (JavaScript)
// @GetMapping(SELECT) / @PostMapping(INSERT) / @PutMapping(UPDATE) / @DeleteMapping(DELETE)
// => web : @GetMapping(SELECT) / @PostMapping(INSERT)
// @RequestMapping (통합) => Spring 6 => 제거 
@RestController
@CrossOrigin(origins = "*")
public class GoodsRestController {
   @Autowired
   private GoodsService gService;
   
   // 사용자 요청에 따라서 요청처리 
   // -------- URI주소 
   @GetMapping(value="goods/list_vue.do", produces = "text/plain;charset=UTF-8")
   // Boot => @RestController => text/plain
   public String goods_list_vue(int page)
   {
	   int rowSize=12;
	   int start=(rowSize*page)-(rowSize-1);
	   int end=rowSize*page;
	   List<GoodsVO> list=gService.goodsListData(start, end);
	   int totalpage=gService.goodsTotalPage();
	   
	   final int BLOCK=10;
	   int startPage=((page-1)/BLOCK*BLOCK)+1;
	   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	   
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   Map map=new HashMap();
	   map.put("list", list);
	   map.put("curpage", page);
	   map.put("startPage", startPage);
	   map.put("endPage", endPage);
	   map.put("totalpage", totalpage);
	   
	   // {curpage:1,totalpage:20...list:[{},{},{}]}
	   String json="";
	   try
	   {
		   ObjectMapper mapper=new ObjectMapper();
		   json=mapper.writeValueAsString(map);
	   }catch(Exception ex) {}
	   
	   return json;
   }
   
   @GetMapping(value="goods/detail_vue.do", produces = "test/plain;charset=UTF-8")
   public String goods_detai_vue(int no)
   {
	   String json = "";
	   GoodsVO vo = gService.goodsDetailData(no);
	   String strPrice = vo.getGoods_price();
	   
	   strPrice = strPrice.replaceAll("[^0-9]", "");
	 
	   vo.setPrice(Integer.parseInt(strPrice));
	   try {
		ObjectMapper mapper = new ObjectMapper();
		json = mapper.writeValueAsString(vo);
	} catch (Exception e) {
		e.printStackTrace();
	}
	                    
	   return json;
   }
   
   
   
   
   
   
   
}