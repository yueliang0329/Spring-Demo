package com.gzj.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class AMCalculatorLoggingProxy {

	private AMCalculatior target;
	
	public AMCalculatorLoggingProxy(AMCalculatior target) {
		super();
		this.target = target;
	}

	public AMCalculatior getLoggingProxy() {
		AMCalculatior proxy=null;
		ClassLoader loader=target.getClass().getClassLoader();
		Class[] interfaces = new Class[]{AMCalculatior.class};
		InvocationHandler h=new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				String methodName=method.getName();
				System.out.println("The method "+methodName+" begins with "+Arrays.asList(args));
				Object result=method.invoke(target, args);
				System.out.println("The method "+methodName+" ends with "+result);
				return result;
			}
		};
		proxy=(AMCalculatior) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
}
