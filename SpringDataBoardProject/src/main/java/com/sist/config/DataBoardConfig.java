package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@ComponentScan(basePackages = "com.sist")
//<context:component-scan base-package="com.sist.*"/>
@MapperScan(basePackages = "com.sist.mapper")


public class DataBoardConfig implements WebMvcConfigurer{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
		// 활성화 => HandlerMapping : 해당 모델을 찾아서 메소드 호출                                    
	}
	/*
		<!-- 3. ViewResolver -->
			<bean id="viewResolver"
				class="org.springframework.web.servlet.view.InternalResourceViewResolver"
				p:prefix="/"
				p:suffix=".jsp"
			/>
	*/
	@Bean("viewResolver")
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	/*
		<bean id="multipartResolver"
				class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
	*/
	@Bean("multipartResolver")
	public MultipartResolver multipartResolver()
	{
		CommonsMultipartResolver mr = new CommonsMultipartResolver();
		return mr;
	}
	
	/*
		<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
			p:dataSource-ref="ds"
	/>
	*/
	@Bean("ds")
	public DataSource dataSoucre()
	{
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:this:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	@Bean("ssf")
	public SqlSessionFactory sessionFactory() throws Throwable
	{
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(dataSoucre());
		return ssf.getObject();
	}
}
