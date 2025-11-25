package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
<bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
			p:driverClassName="oracle.jdbc.driver.OracleDriver"
			p:url="jdbc:oracle:thin:@localhost:1521:XE"
			p:username="hr"
			p:password="happy"
			p:maxActive="30"
			p:maxIdle="10"
			p:maxWait="-1"
		/>
		
		<bean id="dataSource" 
          class="net.sf.log4jdbc.Log4jdbcProxyDataSource"> 
	      <constructor-arg ref="ds" /> 
	      <property name="logFormatter"> 
	        <bean class="net.sf.log4jdbc.tools.Log4JdbcCustomFormatter"> 
	        <property name="loggingType" value="MULTI_LINE" /> 
	        <property name="sqlPrefix" value="SQL : "/> 
	        </bean> 
	      </property> 
	    </bean>
		
		
		<!-- DataSoucre 마이바티스로 전송 -->
		<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
			p:dataSource-ref="dataSource"
		/>
		
		<!-- Mapper 구현 요청 -->
		<mybatis-spring:scan base-package="com.sist.mapper"
			factory-ref="ssf"
		/>
*/
@Configuration
@MapperScan(basePackages = "com.sist.mapper")	// Mapper 구현 요청
public class DatabaseConfig {
	@Bean("ds")
	public DataSource dataSource()
	{
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		ds.setMaxActive(30);
		ds.setMaxIdle(10);
		ds.setMaxWait(-1);
		
		return ds;
	}
	
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		
		return ssf.getObject();
	}
}
