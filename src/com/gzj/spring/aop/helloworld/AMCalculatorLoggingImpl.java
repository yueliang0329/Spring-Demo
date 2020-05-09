package com.gzj.spring.aop.helloworld;

public class AMCalculatorLoggingImpl implements AMCalculatior {

	@Override
	public int add(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("The method add start with ["+i+","+j+"]");
		int result=i+j;
		System.out.println("The method add end with "+result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("The method sub start with ["+i+","+j+"]");
		int result=i-j;
		System.out.println("The method sub end with "+result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("The method mul start with ["+i+","+j+"]");
		int result=i*j;
		System.out.println("The method mul end with "+result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("The method div start with ["+i+","+j+"]");
		int result=i/j;
		System.out.println("The method div end with "+result);
		return result;
	}

}
