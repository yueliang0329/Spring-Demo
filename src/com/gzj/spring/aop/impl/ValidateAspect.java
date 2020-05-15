package com.gzj.spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1) //设置切面的优先级，值越小优先级越高
@Component
@Aspect
public class ValidateAspect {

	@Before("com.gzj.spring.aop.impl.LoggingAspect.expression()")
	public void validateArgs(JoinPoint jp)
	{
		System.out.println("-->validate "+Arrays.asList(jp.getArgs()));
	}
}
