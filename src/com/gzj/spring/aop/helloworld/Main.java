package com.gzj.spring.aop.helloworld;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AMCalculatior cal=new AMCalculatorLoggingImpl();		
		AMCalculatior target=new AMCalculatorImpl();
		AMCalculatior proxy=new AMCalculatorLoggingProxy(target).getLoggingProxy();
		
		int result=proxy.add(2, 3);
		System.out.println("！！>"+result);
		result=proxy.div(6, 3);
		System.out.println("！！>"+result);
	}

}
