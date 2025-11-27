package com.sist.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor	// 모든 매개변수강 있는 생성자 생성
@NoArgsConstructor	// 매개변수가 없는 생성자 생성
public class EmpVO {
	private int empno;
	private String ename, job;
}
