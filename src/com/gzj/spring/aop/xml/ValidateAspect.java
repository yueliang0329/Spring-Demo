package com.gzj.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


public class ValidateAspect {

	public void validateArgs(JoinPoint jp)
	{
		System.out.println("-->validate "+Arrays.asList(jp.getArgs()));
	}
}
