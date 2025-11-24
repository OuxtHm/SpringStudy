package com.sist.main4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
        A a=(A)app.getBean("a");
        a.sayHello("홍길동");
        
        B b=(B)app.getBean("b");
        b.sayHello("심청이");
        
        C c=(C)app.getBean("c");
        c.sayHello("박문수");
	}

}