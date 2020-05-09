package com.gzj.spring.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("postProcessBeforeInitialization..."+bean+","+beanName);
		if("car".equals(beanName))
		{
			Car car=new Car();
			car.setBrand("Ford");
			return car;
		}
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("postProcessAfterInitialization..."+bean+","+beanName);
		return bean;
	}
}
