package com.gzj.spring.beans.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
			
	//	NewPerson person=(NewPerson)ctx.getBean("person4");
	//	System.out.println(person);
	//	DataSource source=(DataSource) ctx.getBean("datasource");
	//	System.out.println(source.getProperties());
		Person person5=(Person)ctx.getBean("person6");
		System.out.println(person5);
	}
}
