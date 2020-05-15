package com.gzj.spring.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-aop-xml.xml");
		AMCalculatior amCalculatior = (AMCalculatior) ctx.getBean("AMCalculatorImpl");
		 int  result=amCalculatior.div(6,2);
		 System.out.println("result:"+result);
	}

}
