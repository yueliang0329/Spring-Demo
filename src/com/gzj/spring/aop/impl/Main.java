package com.gzj.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-aop.xml");
		AMCalculatior amCalculatior = (AMCalculatior) ctx.getBean("AMCalculatior");
		 int  result=amCalculatior.div(6,2);
		 System.out.println("result:"+result);
	}

}
