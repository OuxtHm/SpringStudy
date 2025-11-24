package com.sist.main2;

public class HelloImpl implements Hello{
	@Override
	public void sayHello(String name) {
		System.out.println(name+"님 환영합니다~");
		Hello hello = new HelloImpl();
		hello.sayHello("홍길동");
	}
}
