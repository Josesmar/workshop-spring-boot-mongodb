package com.josesmar.workshopmongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josesmar.workshopmongodb.entities.User;
import com.josesmar.workshopmongodb.repository.UserRepository;
import com.josesmar.workshopmongodb.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();		
	}

	
	public User findById(String id) {	
		Optional<User> user = userRepository.findById(id);	
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));		
	}
}
