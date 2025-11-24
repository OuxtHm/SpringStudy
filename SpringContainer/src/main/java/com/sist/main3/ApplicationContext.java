package com.sist.main3;
import java.util.*;
public class ApplicationContext {
	private Map clasMap = new HashMap();
	public ApplicationContext()
	{
		clasMap.put("a", new A());
		clasMap.put("b", new B());
		clasMap.put("c", new C());
	}
	public Print getBean(String key)
	{
		return (Print)clasMap.get(key);
	}
}
