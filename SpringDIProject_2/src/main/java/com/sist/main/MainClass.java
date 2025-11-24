package com.sist.main;

/*
 	=> Container ; 클래스를 관리하는 영역
 		| bean에 등록된 모든 클래스 (컴포넌트)
 		| VO => 데이터형이기 때문에 등록하지 않는다
 		-----------------
 		BeanFactory : DI
 			|
 		ApplicationContext : DI / AOP
 			|	AnnotationConfigApplicationContext(어노테이션 사용시)
 		WebApplicationContext : MVC
 		=> 결합성이 낮은 프로그램
 			(클래스를 수정 => 다른 클래스의 영향력)
 		=> 상속 / 인터페이스 상속없이 사용(일반 클래스 : ***POJO)
 												  ----
 		1) DI => 값 설정하는 방법
 				-------------- setter DI / constructor DI
 		2) 공통으로 사용되는 기능 : 자동화 처리 => AOP
 			=> 트랜잭션 사용 / 로그 파일
 			=> MVC : 공통 예외처리
 		3) 스프링은 반복적인 코딩X
 		4) MVC => 1차 프로젝트와 동일
 		---------------------------
 		5) 인증 / 인가 => 권한부여 : Security
 		---------------------------------------------------
 		=> VueJS 
 		---------------------------------------------------
	DL		DI 		AOP		=> MVC
	|		|		|			| Web 개발 (첨부된 라이브러리)	
	|		|		공통모듈
	|		객체 생성 시에 필요한 멤버변수의 값을 주입
	클래스 찾기 (getBean(id명))

	동작 순서
	-------
	1. 객체 생성
		------- 라이브러리 => XML, Annotation
		<bean id="" class="" scope=""> : 클래스 한 개 등록
		<context:component-scan basepackage="">
		------------------------------------------------
		id : 중복없이 사용
		class : 패키지부터 등록
		scope : singleton(메모리를 한 개만 사용 : 디폴트) / prototype(clone => 객체 복제)
	2. 값을 주입
		=> 멤버변수에만 주입이 가능
			초기값 설정 : ORM(데이터베이스 연동 => MyBatis)
		=> setter : setXxx(여기에 값 설정)
			p:name="홍" => setName("홍")
		=> constructor : 생성자(변수에 값을 채운다)
			c:name="심" => Member(String name)
		
		=> method DI
			init-method : 객체 생성 시 마다 호출
			destroy-method : 객체 소멸 시 마다
			=> 빅데이터
	3. 개발자가 사용 : 클래스를 스프링으로부터 얻어서 기능 설정(메소드 호출)
	4. 소멸 요청
	----------------------------------------------------------
	객체 생명주기 : 생성 => 값 설정 => 소멸
							  | 개발자 사용
	=> 관계도가 단순하다
	=> 독립적인 클래스 => 다른 클래스에 영향이 없다
	
	=> 작은 의미 : 객체 생성시에 필요한 값을 주입
	=> 큰 의미 : 객체와 객체의 연관관계를 설정 
	--------------------------------------- DI
	
	
	
	
*/
public class MainClass {
	public static void main(String[] args) {
		
	}
}	
