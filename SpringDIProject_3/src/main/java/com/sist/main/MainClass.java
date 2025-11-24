package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
	application-content.xml
	application-datasource.xml
	application-security.xml
	application-sebsocket.xml
*/
public class MainClass {
	public static void main(String[] args) {
		//String[] xml= {"student-app.xml", "member-app.xml", "sawon-app.xml"};
		//ApplicationContext app = new ClassPathXmlApplicationContext(xml);
		ApplicationContext app = new ClassPathXmlApplicationContext("*-app.xml");
		
		Member m = (Member)app.getBean("mem");
		System.out.println("번호: " + m.getNo());
		System.out.println("이름: " + m.getName());
		System.out.println("성별: " + m.getSex());
		
		Student s = (Student)app.getBean("std");
		System.out.println("번호: " + s.getHakbun());
		System.out.println("이름: " + s.getName());
		System.out.println("성별: " + s.getSex());
		
		Sawon sa = (Sawon)app.getBean("sa");
		System.out.println("사번: " + sa.getSabun());
		System.out.println("이름: " + sa.getName());
		System.out.println("성별: " + sa.getSex());
	}
}
