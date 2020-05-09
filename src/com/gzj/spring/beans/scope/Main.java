package com.gzj.spring.beans.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gzj.spring.beans.autowire.Address;
import com.gzj.spring.beans.autowire.Car;
import com.gzj.spring.beans.autowire.Person;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-scope.xml");
	//	Address address=(Address) ctx.getBean("address");		
	//	System.out.println(address);
		Car car=(Car)ctx.getBean("car");
		Car car2=(Car)ctx.getBean("car");
		System.out.println(car==car2);
	}

}
