package com.sist.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.config.StudentConfig;

/*
	컨테이너 
		ApplicationContext
		AnnotationConfigApplicationContext
		
		=> WebApplicationContet
			(숨겨져 있다)
			DispatcherServlet

	=> DI를 사용하는 클래스
		: 사용자 정의
		: 라이브러리 클래스
			========== 데이터베이스 / 보안
			

*/
public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(StudentConfig.class);
		Student std = (Student)app.getBean("std");
		
		System.out.println("학번: " + std.getHakbun());
		System.out.println("이름: " + std.getName());
		System.out.println("성별: " + std.getSex());
		System.out.println("학과: " + std.getSubject());
	}
}	
