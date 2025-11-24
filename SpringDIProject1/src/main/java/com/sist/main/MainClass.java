package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *   스프링 : 개발에 필요한 클래스 관리(복잡한 클래스 관리) 
 *                     ---------
 *                     컨테이너 : 클래스로 제작됨 :=> 가볍다 
 *                     => 경량 컨테이너 
 *                     => 생성 = 활용 = 소멸 
 *                                    ---- 스프링에서 소멸
 *                        --- 스프링에서 생성 
 *                     => 라이브러리 : 클래스가 제작되어 있다 
 *                        => 자바를 코딩이 불가능 
 *                        => XML / 자바 이용 
 *   컨테이너 (Container) : 클래스 관리 영역 (등록된 모든 클래스 관리)
 *   -------------------
 *         BeanFactory : core =>Container/DI  
 *             |
 *       ***ApplicationContext : core => AOP (공통모듈) 
 *             | => AnnotationConfigApplicationContext(자바 전용)
 *               
 *      ***WebApplicationContext : core => AOP (공통모듈)  + MVC
 *      
 *    => 주입 => 생성 / 소멸 관리 한다 
 *              | new를 사용하지 않고 컨테이너를 통해서 객체를 얻어서 사용 
 *              | new사용은 ~VO(데이터형)
 *    => 두가지 방식 
 *       1) XML 
 *       2) Annotaion 
 *       3) 자바이용 방식 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // XML 파싱 
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		
		// 1. 생성된 객체 읽기 
		Sawon sa1=(Sawon)app.getBean("sa1");
		sa1.print();
		
		Sawon sa2=(Sawon)app.getBean("sa2");
		sa2.print();
		
		Sawon sa3=(Sawon)app.getBean("sa3");
		sa3.print();
	}

}