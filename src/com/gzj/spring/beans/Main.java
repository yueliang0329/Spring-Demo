package com.gzj.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过bean的id获取
		HelloWorld helloWorld=(HelloWorld)ctx.getBean("helloWorld");
		//通过类获取，要求bean是唯一的
		//HelloWorld helloWorld=ctx.getBean(HelloWorld.class);
		//helloWorld.hello();
		
		Car car=(Car)ctx.getBean("car");
		System.out.println(car);
		
		car=(Car)ctx.getBean("car2");
		System.out.println(car);
		
		Person person=(Person)ctx.getBean("person");
		System.out.println(person);
		
		Person person2=(Person)ctx.getBean("person2");
		System.out.println(person2);
	}
}
