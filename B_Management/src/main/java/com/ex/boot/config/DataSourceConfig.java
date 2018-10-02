package com.ex.boot.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

	@Bean(name="firstDataSource")
	@ConfigurationProperties(prefix = "datasource.mservice")
	public DataSource FirstDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="firstTransactionManager")
	public DataSourceTransactionManager FirstTransactionManager(@Qualifier("firstDataSource")DataSource dataSource){
		final DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
		return transactionManager;
	}
	
	@Bean(name="firstSqlSessionFactory")
	public SqlSessionFactory FirstSqlSessionFactory(@Qualifier("firstDataSource")DataSource dataSource,ApplicationContext applicationContext) throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(FirstDataSource());
	    sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:mappers/*.xml"));
	    return sqlSessionFactory.getObject();
	} 
	
	@Bean(name="firstSqlSessionTemplate")
	public SqlSessionTemplate FirstSqlSessionTemplate(@Qualifier("firstSqlSessionFactory")SqlSessionFactory sqlSessionFactory)throws Exception{
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
