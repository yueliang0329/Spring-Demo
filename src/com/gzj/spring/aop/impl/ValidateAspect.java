package com.gzj.spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1) //������������ȼ���ֵԽС���ȼ�Խ��
@Component
@Aspect
public class ValidateAspect {

	@Before("com.gzj.spring.aop.impl.LoggingAspect.expression()")
	public void validateArgs(JoinPoint jp)
	{
		System.out.println("-->validate "+Arrays.asList(jp.getArgs()));
	}
}
