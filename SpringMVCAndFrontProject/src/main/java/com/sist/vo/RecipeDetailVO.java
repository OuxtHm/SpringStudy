package com.sist.vo;

import lombok.Data;

// VO => Mapper => DAO => Service => Controller => JSP
//									 RestController = Vue
//					|오라클  | 기타 기능 추가 | 브라우저 전송
/*
 NO                                                 NUMBER
 POSTER                                    NOT NULL VARCHAR2(500)
 TITLE                                     NOT NULL VARCHAR2(1000)
 CHEF                                      NOT NULL VARCHAR2(300)
 CHEF_POSTER                               NOT NULL VARCHAR2(500)
 CHEF_PROFILE                              NOT NULL VARCHAR2(500)
 INFO1                                     NOT NULL VARCHAR2(100)
 INFO2                                     NOT NULL VARCHAR2(100)
 INFO3                                     NOT NULL VARCHAR2(100)
 CONTENT                                   NOT NULL CLOB
 FOODMAKE                                  NOT NULL CLOB
 
 @Controller : 화면 제어
 	| forward / redirect (JSP)
 @RestController : 자바스크립트에 출력 값 전송
 	| Ajax / Vue / React (JSP / HTML)
 			 | router
 			 | return "forward:/index.html"
 			 	일반 CDN / Module
 			 	-------   --------
	------------------------------------------- Model
Model : ~VO / ~DAO / ~Service / ~Manager
|
View(JSP/HTML) : 화면 출력 역할
-------------------------------------- + (DispaterServlet)
	=> 설정 => 동작에 대한 메뉴얼 작성(XML, Properties)
								 |		| boot => .yml
								 Framwork          ----
								 					|CI/CD
								 					|-> 들여쓰기
	
	
	
*/
@Data
public class RecipeDetailVO {
	private int no;
	private String poster, title, chef, chef_poster, chef_profile, info1, info2, info3, content, foodmake;
}
