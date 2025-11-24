package com.sist.main2;

import java.io.*;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXParseException;


public class ClassPathApplicationContext implements ApplicationContext{
	private Map clsMap = new HashMap();
	
	public ClassPathApplicationContext(String path)
	{
		try {
			 SAXParserFactory spf = SAXParserFactory.newInstance();
			 SAXParser sp = spf.newSAXParser();
			 XMLParse xml = new XMLParse();
			 sp.parse(new File(path), xml);
			 clsMap = xml.getMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Object getBean(String key) {
		return clsMap.get(key);
	}
	
}
