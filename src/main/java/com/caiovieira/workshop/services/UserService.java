package com.caiovieira.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiovieira.workshop.entities.User;
import com.caiovieira.workshop.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	
	public List<User> findAll(){
		return userRepository.findAll();
	}


	public User insert(User user) {
		return userRepository.save(user);
	}
}
