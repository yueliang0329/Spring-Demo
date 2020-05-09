package com.gzj.spring.beans.annotiation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gzj.spring.beans.annotiation.controller.UserController;
import com.gzj.spring.beans.annotiation.repository.UserRepository;
import com.gzj.spring.beans.annotiation.service.UserService;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-annotiation.xml");	
//		TestObject to=(TestObject) ctx.getBean("testObject");
//		System.out.println(to);
		UserController userController= (UserController) ctx.getBean("userController");
		System.out.println(userController);
		userController.execute();
//		UserService userService=(UserService) ctx.getBean("userService");
//		System.out.println(userService);
//		UserRepository userRepository =(UserRepository) ctx.getBean("userRepository");
//		System.out.println(userRepository);
	}
	
}
