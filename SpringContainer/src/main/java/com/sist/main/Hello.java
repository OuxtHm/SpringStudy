package com.sist.main;

public class Hello {
	public void sayHello(String name)
	{
		System.out.println(name + "님 환영합니다");
		Hello hello = new Hello();
		hello.sayHello("홍길동");
	}
}
