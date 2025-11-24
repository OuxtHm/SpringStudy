package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
	스프링 : 개발에 필요한 클래스 관리(복잡한 클래스 관리)
					  ----------
					  컨테이너 : 클래스로 제작됨 - 가벼움
					  => 경량 컨테이너
					  => 생성 = 활용 = 소멸
					  	  | 		----- 스프링에서 소멸
					    ----- 스프링에서 생성
					  => 라이브러리 : 클래스가 제작되어 있다
					  	=> 자바를 코딩이 불가능
					  	=> XML / 자바 이용
	컨테이너(Container) : 클래스 관리 영역 (등록된 모든 클래스 관리)
	-------------------
		BeanFactory : core => Container/DI
			|
		***ApplicationContext : core => AOP(공통 모듈)
			|	=> AnnotationConfigApplicationContext(자바 전용)
		***WebApplicationContext : core => AOP(공통 모듈) + MVC
	
	=> 주입 => 생성 / 소멸 관리한다
			   | new를 사용하지 않고 컨테이너를 통해 객체를 얻어서 사용
			   | new 사용은 ~VO(데이터형)
	=> 두가지 방식
	 	1) XML
	 	2) Annotation
	 	3) 자바 이용 방식
	
	스프링 컨테이너 동작
	1) 스프링 컨테이너 생성
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
	2) Bean 생성(클래스 객체 생성)
		<bean id="아이디명1" class="패키지.클래스명">
		
		=> map.put("아이디명1", Class.forName(패키지.클래스명));
		
		<bean id="아이디명2" class="패키지.클래스명">
		=> map.put("아이디명2", Class.forName(패키지.클래스명));
		
		<bean id="아이디명3" class="패키지.클래스명">
		=> map.put("아이디명3", Class.forName(패키지.클래스명));
		
		*** 모든 객체는 싱글턴을 이용한다. (저장된 객체 주소가 변경이 안된다)
		*** getBean()을 호출할 때 마다 => 객체 생성이 가능
			scope="singleton" scope="prototype"
	3) DI 수행 => setter, 생성자를 이용한 데이터 주입
	4) 요청 메소드 호출
		= 객체 생성시 => init-method
		= 객체 소멸시 => destroy-method
	5) 개발자가 객체 활용
	6) 종료 => System.gc()를 호출 : 메모리 해제
	
	=> 컨테이너 : 객체의 생명주기
		1) class 읽기
		2) 클래스 메모리 할당
		3) setter 멤버변수 값 주입
		------------------------------- Spirng
		4) 개발자가 필요한 메소드 -> 활용
		------------------------------- 
		5) 사용 후 메모리 해제
		------------------------------- Spring
		
		XMl => 예전
		---------
		Annotation / 자바로 변경됨
		
		1) 컨테이너 확인
		2) ***DI
		------------------- 모든 영역의 필수 : core
		3) ***AOP
		4) ***MVC
			= ORM
		5) ***Transaction
		6) Spiring Security
		
	*/
public class MainClass {

	public static void main(String[] args) {
		// XML 파싱
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		// 1. 생성된 객체 읽기
		Sawon sa1 = (Sawon)app.getBean("sa1");
		sa1.print();
		
		Sawon sa2 = (Sawon)app.getBean("sa2");
		sa2.print();
		
		Sawon sa3 = (Sawon)app.getBean("sa3");
		sa3.print();
	}

}
