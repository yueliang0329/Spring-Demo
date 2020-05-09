package com.gzj.spring.beans.annotiation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gzj.spring.beans.annotiation.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	@Qualifier("userRepositoryImpl")
	private UserRepository userRepository;
	public void add() {
		System.out.println("UserService add()...");
		userRepository.save();
	}
	
}
