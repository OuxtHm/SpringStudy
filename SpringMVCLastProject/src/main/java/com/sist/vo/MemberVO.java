package com.sist.vo;

import lombok.Data;

/*
USERID       VARCHAR2(20)  
USERPWD      VARCHAR2(300) 
USERNAME     VARCHAR2(50)  
SEX          VARCHAR2(10)  
ENABLE       NUMBER        
AUTHORITY    VARCHAR2(20) 
*/
@Data
public class MemberVO {
	private String userid, username, userpwd, sex, authority;
	private int enable;
}
