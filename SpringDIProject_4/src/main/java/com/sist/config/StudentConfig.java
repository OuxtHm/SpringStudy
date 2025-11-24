package com.sist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sist.main.Student;

@Configuration
public class StudentConfig {
	@Bean("std")	// <bean id="std" class="com.sist.main.Student>
	public Student student()
	{
		Student s = new Student();
		s.setHakbun(1);	// p:hakbun
		s.setName("홍길동");	// p:name
		s.setSex("남자");		// p:sex
		s.setSubject("컴퓨터");	// p:subject
		return s;
	}
}
