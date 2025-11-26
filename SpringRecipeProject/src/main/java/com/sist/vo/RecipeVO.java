package com.sist.vo;

import lombok.Data;

/*
NO         NOT NULL NUMBER         
TITLE      NOT NULL VARCHAR2(4000) 
POSTER     NOT NULL VARCHAR2(260)  
CHEF       NOT NULL VARCHAR2(500)  
LINK                VARCHAR2(100)  
HIT                 NUMBER         
LIKECOUNT           NUMBER         
JJIMCOUNT           NUMBER         
REPLYCOUNT          NUMBER    
*/
@Data
public class RecipeVO {
	private int no;
	private String title, chef; 
}
