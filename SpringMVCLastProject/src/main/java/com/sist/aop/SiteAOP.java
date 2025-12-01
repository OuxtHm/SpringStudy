package com.sist.aop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.service.FoodService;
import com.sist.vo.FoodVO;

@Aspect	// 공통 기반의 처리가 있는 경우 처리
// footer : Cookie 처리
@Component
public class SiteAOP {
	@Autowired
	private FoodService fService;
	/*	
		1. request, response, session => 내장 객체
			=> DispatcherServlet
					|
				Controller / RestController
		2. request를 강제로 가지고 오는 경우
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
	*/
	
	// finally 일 경우
	@After("execution(* com.sist.web.*Controller.*(..))")
	public void after()
	{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
	
		Cookie[] cookies = request.getCookies();
		List<FoodVO> cList = new ArrayList<FoodVO>();
		
		
		if(cookies != null)
		{
			for(int i = cookies.length - 1; i >= 0; i--)
			{
				if(cookies[i].getName().startsWith("food_"))
				{
					String fno = cookies[i].getValue();
					FoodVO vo = fService.foodCookieData(Integer.parseInt(fno));
					cList.add(vo);
				}
			}
			request.setAttribute("cList", cList);
		}
	}
}
