package com.sist.main2;

public class MainClass {

	public static void main(String[] args) {
		String path = "C:\\Users\\sist\\git\\SpringStudy\\SpringDIProject_2\\src\\main\\java\\app.xml";
		ApplicationContext app = new ClassPathApplicationContext(path);
		Sawon sa = (Sawon)app.getBean("sa");
		System.out.println("사번 : " + sa.getSabun());
		System.out.println("이름 : " + sa.getName());
		System.out.println("부서 : " + sa.getDept());
		System.out.println("직위 : " + sa.getJob());
	}

}
