package com.gzj.spring.beans;

public class HelloWorld {
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
		System.out.println("setName:"+userName);
	}
	
	public void hello() {
		System.out.println("Hello:"+userName);
	}

	public HelloWorld() {
		super();
		System.out.println("HelloWorld's Constructor...");
	}
	
}
