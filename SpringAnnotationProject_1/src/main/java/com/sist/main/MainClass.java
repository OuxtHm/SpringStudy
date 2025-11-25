package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.MyDAO;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("application-*.xml");
		
		MyDAO dao = (MyDAO)app.getBean("dao");
		
		dao.select();
		System.out.println("===========");
		dao.delete();
		System.out.println("===========");
		dao.insert();
		System.out.println("===========");
		dao.update();
		
	}
	
}
