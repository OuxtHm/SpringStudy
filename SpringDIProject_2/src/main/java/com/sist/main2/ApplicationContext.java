package com.sist.main2;

// DL => 객체를 찾는 역할
public interface ApplicationContext {
	public Object getBean(String key);
}
