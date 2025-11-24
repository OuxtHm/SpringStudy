package com.sist.main2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("app2.xml");
		
		// 개발자 사용
		Member mem1=(Member)app.getBean("mem1");
		mem1.print();	
		//app.close();
	
		Member mem2 = (Member)app.getBean("mem2");
		Member mem3 = (Member)app.getBean("mem2");
		Member mem4 = (Member)app.getBean("mem2");
		
		System.out.println("mem2=" + mem2 );
		System.out.println("mem3=" + mem3 );
		System.out.println("mem4=" + mem4 );
		
		Member mem5 = (Member)app.getBean("mem1");
		Member mem6 = (Member)app.getBean("mem1");
		
		System.out.println("mem1=" + mem1);
		System.out.println("mem5=" + mem5);
		System.out.println("mem6=" + mem6);
	}
}
