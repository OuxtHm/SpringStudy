package com.sist.main2;

import java.lang.reflect.Method;

/*
	1. DOM => 메모리에 트리형태로 저장 후 값 제어
				수정 / 추가 / 읽기 / 삭제
				속도가 늦다
	2. SAX => 태그 한 개씩 읽어서 데이터만 추출   Spring / MyBatis
	
	<?xml version="1.0"?> => startDocument() : 문서의 시작
	<beans> => startElement()
		<bean>	=> startElement()
			값	=> characters()
		</bean>	=> endElement()
		
		<bean => startElement()>
			값 => characters()
		</bean>=> endElement()
	</beans>
	---------------------------------------- endDocument()
*/

import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParse extends DefaultHandler{
	private Map map = new HashMap();

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try {
			if(qName.equals("bean"))
			{
				String id = attributes.getValue("id");
				String cls = attributes.getValue("class");
				String sabun = attributes.getValue("p:sabun");
				String name = attributes.getValue("p:name");
				String dept = attributes.getValue("p:dept");
				String loc = attributes.getValue("p:loc");
				String job = attributes.getValue("p:job");
				String[] aName = {sabun, name, dept, loc};
				String[] ss = {
						attributes.getQName(2),
						attributes.getQName(3),
						attributes.getQName(4),
						attributes.getQName(5)	
				};
				Class clsName = Class.forName(cls);	// 클래스 메모리 할당(객체 생성)
				Object obj = clsName.getDeclaredConstructor().newInstance();
				
				// new Sawon()
				Method[] methods = clsName.getDeclaredMethods();
				for(Method m : methods)
				{
					String mName = m.getName();
					for(int i = 0; i < ss.length; i++)
					{
						if(mName.equalsIgnoreCase("set" + ss[i].substring(ss[i].indexOf(":") + 1)))
						{
							if(i == 0)
								m.invoke(obj, Integer.parseInt(aName[i]));
							else
								m.invoke(obj, aName[i]);
						}
					}
				}
				map.put(id, obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map getMap() {
		return map;
	}
	
}
