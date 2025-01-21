package com.caiovieira.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiovieira.workshop.entities.User;
import com.caiovieira.workshop.repositories.UserRepository;
import com.caiovieira.workshop.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id){
		Optional<User> obj = userRepository.findById(id);
		
		if (obj.orElse(null) == null) {
			throw new ObjectNotFoundException("Usuário não encontrado");
		}
		
		return obj.get();
	}

	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public User update(String id, User user) {
		User userObj = findById(id);
		updateData(userObj, user);
		return userRepository.save(userObj);
	}

	private void updateData(User userObj, User user) {
		userObj.setName(user.getName());
		userObj.setEmail(user.getEmail());
	}
	
	public void delete(String id) {
		User user = findById(id);
		userRepository.deleteById(user.getId());
	}
	
}
