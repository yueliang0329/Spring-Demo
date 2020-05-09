package com.gzj.spring.beans.annotiation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gzj.spring.beans.annotiation.TestObject;

@Repository
public class UserRepositoryImpl implements UserRepository {

//	@Autowired(required=false)
	@Autowired
	private TestObject testObject;
	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserRepository save()...");
		System.out.println(testObject);
	}

}
