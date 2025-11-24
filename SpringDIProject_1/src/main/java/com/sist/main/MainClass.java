package com.sist.main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.vo.*;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		EmpDAO dao = (EmpDAO)app.getBean("dao");
		List<EmpVO> list = dao.empListData();
		
		for(EmpVO vo : list)
		{
			System.out.println(vo.getEmpno() + " " + vo.getEname() + " " + vo.getSal() + " " + vo.getJob() + " " + vo.getDbday());
			
		}
		System.out.println("===========사원정보============");
		EmpVO vo = dao.empDetailData(7788);
		System.out.println("사번: " + vo.getEmpno());
		System.out.println("이름: " + vo.getEname());
		System.out.println("직위: " + vo.getJob());
		System.out.println("급여: " + vo.getSal());
		System.out.println("입사일: " + vo.getDbday());
	}

}
