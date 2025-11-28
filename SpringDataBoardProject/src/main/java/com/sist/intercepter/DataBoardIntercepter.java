package com.sist.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
	FrontController : 요청을 받아 => HandlerMapping
	(DispatcherServlet)					|	=> 다른 기능 수행
											| interceptor : preHandle
											| 자동 로그인
										Model을 찾기 시작
											|
										메소드 호출
											=> return ""
												| interceptor : postHandle => After-Returning
											ViewResolver
												| request를 전송
												| interceptor : afterCompletion
											   JSP
										----------------------------------------- AOP

*/
// XML에서 메모리 할당
public class DataBoardIntercepter extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Intercepter : preHandle() Call...");
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Interceptor : postHandle() Call...");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("Interceptor : afterCompletion() Call...");
		super.afterCompletion(request, response, handler, ex);
	}
	
}
