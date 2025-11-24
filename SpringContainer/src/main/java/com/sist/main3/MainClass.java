package com.sist.main3;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext app = new ApplicationContext();
		
		Print p = app.getBean("a");
		p.print();
		
		p = app.getBean("b");
		p.print();
		
		p = app.getBean("c");
		p.print();
		
		
	}

}
