//package com.spring.config;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//
//@Configuration
//@MapperScan(basePackages = {"com.spring.mapper"})
//@ComponentScan(basePackages = {"com.spring.service"})
//public class RootConfig {
//	
//	@Bean
//	public DataSource dataSource() {
//		HikariConfig hikariConfig = new HikariConfig();
//		hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/scott?serverTimezone=Asia/Seoul");
//		
//		hikariConfig.setUsername("scott");
//		hikariConfig.setPassword("tiger");
//		
//		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
//		
//		return dataSource;
//	}
//	
//	@Bean
//	public SqlSessionFactory sqlSessionFactory() throws Exception {
//		
//		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//		sqlSessionFactory.setDataSource(dataSource());
//		return (SqlSessionFactory) sqlSessionFactory.getObject();
//	}
//	
//}