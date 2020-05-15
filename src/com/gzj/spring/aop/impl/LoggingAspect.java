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

//�����������Ϊһ�����棺��Ҫ�Ѹ���ŵ�AOP�����У�������Ϊһ������
@Aspect
@Component
@Order(2)
public class LoggingAspect {
	
	//���巽�������������ʽ �������ֱ֪ͨ��ʹ�÷������������������ʽ
	@Pointcut("execution(* com.gzj.spring.aop.impl.AMCalculatior.*(int, int))")
	public void expression() {};
	
	//�����÷�����һ��ǰ��֪ͨ
	@Before("expression()")
	public void beforeMethod(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs()) ;
		System.out.println("The method "+methodName+" begins with " + args);
	}
	
	//����֪ͨ����Ŀ�귽��ִ�к������Ƿ����쳣����ִ��֪ͨ
	//���ܷ��ʷ����ķ���ֵ
	@After("expression()")
	public void afterMethod(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" end " );
	}
	
	//����֪ͨ �ڷ�������������ִ�еĴ���
	//���Է��ʵ������ķ���ֵ
	@AfterReturning(value="expression()",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result)
	{
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with "+ result);
	}
	
	//�쳣֪ͨ �ڷ��������쳣��ִ�еĴ��룬���Է��ʵ��쳣�����ҿ���ָ���ڳ����ض��쳣ʱִ�д���
	@AfterThrowing(value="expression()",throwing="ex")
	public void afterthrowing(JoinPoint joinPoint,Exception ex)
//	public void afterthrowing(JoinPoint joinPoint,NullPointerException ex)
	{
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs exception:"+ ex);
	}
	
	//����֪ͨ ��ҪЯ��ProceedingJoinPoint ���͵Ĳ��� ���Ծ����Ƿ�ִ��Ŀ�귽��
	//����֪ͨ�����ڶ�̬�����ȫ���̣��ұ����з���ֵ
//	@Around("execution(* com.gzj.spring.aop.impl.AMCalculatior.*(int, int))")
//	public Object aroundMethod(ProceedingJoinPoint pjd)
//	{
//		Object result = null;
//		String methodName = pjd.getSignature().getName();
//		try {
//			//ǰ��֪ͨ
//			System.out.println("The method "+methodName+" begins with " + Arrays.asList(pjd.getArgs()));
//			result=pjd.proceed();
//			//����֪ͨ
//			System.out.println("The method "+methodName+" ends with " + result);
//		} catch (Throwable e) {
//			//�쳣֪ͨ
//			System.out.println("The method "+methodName+" occurs exception:"+ e);
//		}
//		//����֪ͨ
//		System.out.println("The method "+methodName+" ends");
//		return result;
//	}
}
