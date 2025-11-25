package com.sist.main;

import java.util.List;
import java.util.Scanner;
import com.sist.config.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.service.EmpService;
import com.sist.vo.*;

@Component("mc") // map.put("mc", new MainClass()) => getBean("mc") - getBean의 return형은 Object이기 때문에 받아올 때 형변환 해줘야 한다.
public class MainClass {
	@Autowired
	private EmpService service;
	
	public static void main(String[] args) {
		// 사용자 정의 클래스, 라이브러리 클래스를 관리하는 클래스 => 컨테이너
		// 등록된 모든 클래스를 Map에 저장한다.
		// 패키지 단위 => 사용자의 정의 클래스 / 한 개 클래스 => <bean>
		Class[] cls= {EmpConfig.class, DatabaseConfig.class};
		//ApplicationContext app = new ClassPathXmlApplicationContext("application-*.xml");
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(cls);
		MainClass mc = app.getBean("mc", MainClass.class);
		
		List<EmpVO> eList = mc.service.empListData();
		List<DeptVO> dList = mc.service.deptListData();
		//EmpVO vo = mc.service.empDetailData(7788);
		
		System.out.println("============== 부서 정보 ==============");
		for(DeptVO dvo : dList)
		{
			System.out.println(dvo.getDeptno() + " " + dvo.getDname() + " " + dvo.getLoc());
		}
		
		System.out.println("================== 사원정보 ==================");
		for(EmpVO evo : eList)
		{
			System.out.println(evo.getEmpno() + " " + evo.getEname() + " " + evo.getJob() + " " + evo.getSal() + " " + evo.getDbday());
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("사번 입력 : ");
		int empno = scan.nextInt();
		
		EmpVO vo = mc.service.empDetailData(empno);
		
		System.out.println("사번: " + vo.getEmpno());
		System.out.println("이름: " + vo.getEname());
		System.out.println("직위: " + vo.getJob());
		System.out.println("부서명: " + vo.getDvo().getDname());
		System.out.println("근무지: " + vo.getDvo().getLoc());
		
	}
}
