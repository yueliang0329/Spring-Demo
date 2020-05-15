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
		//����������ĸ������������
		ClassLoader loader=target.getClass().getClassLoader();
		//�����������ͣ�����������Щ����
		Class[] interfaces = {AMCalculatior.class};
		//�����ô���������еķ���ʱ��ִ�иô���
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
