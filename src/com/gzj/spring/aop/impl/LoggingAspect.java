package com.gzj.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//把这个类申明为一个切面：需要把该类放到AOP容器中，再申明为一个切面
@Aspect
@Component
@Order(2)
public class LoggingAspect {
	
	//定义方法声明切入点表达式 ，后面的通知直接使用方法名来引入切入点表达式
	@Pointcut("execution(* com.gzj.spring.aop.impl.AMCalculatior.*(int, int))")
	public void expression() {};
	
	//声明该方法是一个前置通知
	@Before("expression()")
	public void beforeMethod(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs()) ;
		System.out.println("The method "+methodName+" begins with " + args);
	}
	
	//后置通知：在目标方法执行后（无论是否发生异常），执行通知
	//不能访问方法的返回值
	@After("expression()")
	public void afterMethod(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" end " );
	}
	
	//返回通知 在方法正常结束后执行的代码
	//可以访问到方法的返回值
	@AfterReturning(value="expression()",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result)
	{
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with "+ result);
	}
	
	//异常通知 在方法出现异常会执行的代码，可以访问到异常对象，且可以指定在出现特定异常时执行代码
	@AfterThrowing(value="expression()",throwing="ex")
	public void afterthrowing(JoinPoint joinPoint,Exception ex)
//	public void afterthrowing(JoinPoint joinPoint,NullPointerException ex)
	{
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs exception:"+ ex);
	}
	
	//环绕通知 需要携带ProceedingJoinPoint 类型的参数 可以决定是否执行目标方法
	//环绕通知类似于动态代理的全过程，且必须有返回值
//	@Around("execution(* com.gzj.spring.aop.impl.AMCalculatior.*(int, int))")
//	public Object aroundMethod(ProceedingJoinPoint pjd)
//	{
//		Object result = null;
//		String methodName = pjd.getSignature().getName();
//		try {
//			//前置通知
//			System.out.println("The method "+methodName+" begins with " + Arrays.asList(pjd.getArgs()));
//			result=pjd.proceed();
//			//后置通知
//			System.out.println("The method "+methodName+" ends with " + result);
//		} catch (Throwable e) {
//			//异常通知
//			System.out.println("The method "+methodName+" occurs exception:"+ e);
//		}
//		//后置通知
//		System.out.println("The method "+methodName+" ends");
//		return result;
//	}
}
