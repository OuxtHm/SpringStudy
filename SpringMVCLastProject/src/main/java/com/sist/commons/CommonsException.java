package com.sist.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 모든 Controller(Model)의 공통 기반의 예외처리
@ControllerAdvice
public class CommonsException {
	@ExceptionHandler(Exception.class)
	public void exception(Exception e)
	{
		System.out.println("====== 예외처리 발생(Exception) ======");
		e.printStackTrace();
	}
	@ExceptionHandler(Throwable.class)
	public void throwable(Throwable e)
	{
		System.out.println("====== 예외처리 발생(Throwable) ======");
		e.printStackTrace();
	}
}
