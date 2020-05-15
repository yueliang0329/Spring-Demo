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
		//代理对象由哪个类加载器加载
		ClassLoader loader=target.getClass().getClassLoader();
		//代理对象的类型，即其中有哪些方法
		Class[] interfaces = {AMCalculatior.class};
		//当调用代理对象其中的方法时，执行该代码
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
