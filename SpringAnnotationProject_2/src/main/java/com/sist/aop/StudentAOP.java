package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/*
	1. JoinPoint => 어떤 위치(메소드 영역) 
		=> Before
		=> After
		=> After-Returning
		=> After-Throwing
		=> Around
	2. PointCut => 어떤 메소드에 적용
	3. Advice

*/
// 클래스 위에 있는 모든 어노테이션이 메모리 할당을 하는 것은 아니다.
@Aspect		// 메모리 할당이 안되는 어노테이션 => 공통모듈
@Component  
public class StudentAOP {
	@Around("execution(* com.sist.dao.StudentDAO.student*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		System.out.println("사용자가 요청한 메소드:" + jp.getSignature().getName());
		long start = System.currentTimeMillis();
		
		Object obj = jp.proceed();
		
		long end = System.currentTimeMillis();
		System.out.println("수행 시간: " + (end-start));
		
		return obj;
	}
}
