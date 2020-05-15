package com.gzj.spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


public class LoggingAspect {
	
	
	
	public void beforeMethod(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs()) ;
		System.out.println("The method "+methodName+" begins with " + args);
	}
	
	
	public void afterMethod(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" end " );
	}
	
	
	public void afterReturning(JoinPoint joinPoint,Object result)
	{
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with "+ result);
	}
	

	public void afterthrowing(JoinPoint joinPoint,Exception ex)
//	public void afterthrowing(JoinPoint joinPoint,NullPointerException ex)
	{
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs exception:"+ ex);
	}
	

	public Object aroundMethod(ProceedingJoinPoint pjd)
	{
		Object result = null;
		String methodName = pjd.getSignature().getName();
		try {
			//前置通知
			System.out.println("The method "+methodName+" begins with " + Arrays.asList(pjd.getArgs()));
			result=pjd.proceed();
			//后置通知
			System.out.println("The method "+methodName+" ends with " + result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("The method "+methodName+" occurs exception:"+ e);
		}
		//后置通知
		System.out.println("The method "+methodName+" ends");
		return result;
	}
}
