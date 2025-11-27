package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.RecipeMapper;
import com.sist.vo.RecipeVO;

/*
	스프링 -> 클래스 관리 (생성 ~ 소멸 / 공통기반 -> 핵심 코딩)
			---------
			대상 : 기능이 있는 클래스
			-> 제외 = ~VO(데이터형), 인터페이스
	-> 일반 클래스 : @Component
					| AOP / ChatServer / NewsFind
		데이터베이스 처리 : @Repository -> ~DAO
		서비스 : dao에서 다시 처리해야 되는 부분
				-------------------------
				로그인처리 / 비밀번호 : @Service
	모델 : 브라우저와 연결 : @Controller / @RestController
	-------------------------------------------------
	*** 예외처리 : 공통 예외처리 : @ControllerAdvice
	
	1. 세팅이 된 클래스
		------------ 스프링 안에 첨부가 되어있다
					 ---------------------
					 직접 읽기 => getBean(id명)
					 스프링에 의해 처리 => @Autowired
	2. @Autowired ==> 가급적이면 생성자를 이용해서 받는다
	
	----------------
	   id     객체
	----------------
	   a	 new A()--------------------┐주소값
	----------------					|
	   b     new B()		@Autowired	|
	----------------		 private A  a; => A a = new A()
								=> instanceof : 객체 비교
*/
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;	// 구현된 클래스의 주소를 가지고 온다

/*	
	@Select("SELECT no,poster,title,chef,num "
         + "FROM (SELECT no,poster,title,chef,rownum as num "
         + "FROM (SELECT no,poster,title,chef "
         + "FROM recipe "
         + "WHERE no IN(SELECT no FROM recipe INTERSECT "
         + "SELECT no FROM recipeDetail) "
         + "ORDER BY no ASC)) "
         + "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(@Param("start") int start, @Param("end") int end);
	
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
         + "WHERE no IN(SELECT no FROM recipe INTERSECT "
         + "SELECT no FROM recipeDetail)")
	public int recipeTotalPage();
*/
	public List<RecipeVO> recipeListData(int start, int end)
	{
		return mapper.recipeListData(start, end);
	}
	
	public int recipeTotalPage()
	{
		return mapper.recipeTotalPage();
	}
	/*
	 @Select("SELECT no,poster,title,chef,num "
	         + "FROM (SELECT no,poster,title,chef,rownum as num "
	         + "FROM (SELECT no,poster,title,chef "
	         + "FROM recipe "
	         + "WHERE no IN(SELECT no FROM recipe INTERSECT "
	         + "SELECT no FROM recipeDetail) "
	         + "AND ${column} LIKE '%'||#{fd}||'%' "
	         + "ORDER BY no ASC)) "
	         + "WHERE num BETWEEN #{start} AND #{end}")
   public List<RecipeVO> recipeFindData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
	         + "WHERE no IN(SELECT no FROM recipe INTERSECT "
	         + "SELECT no FROM recipeDetail) AND ${column} LIKE '%'||#{fd}||'%' ")
   public int recipeFindTotalPage(Map map);
	
	*/
	
	public List<RecipeVO> recipeFindData(Map map)
	{
		return mapper.recipeFindData(map);
	}
	
	public int recipeFindTotalPage(Map map)
	{
		return mapper.recipeFindTotalPage(map);
	}
}
