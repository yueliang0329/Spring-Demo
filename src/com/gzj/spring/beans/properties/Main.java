package com.gzj.spring.beans.properties;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gzj.spring.beans.autowire.Address;
import com.gzj.spring.beans.autowire.Person;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-properties.xml");
	
		DataSource dataSource= (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
	}

}
