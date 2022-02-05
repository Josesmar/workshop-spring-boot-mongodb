package com.josesmar.workshopmongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.josesmar.workshopmongodb.dto.UserDto;
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
	
	public User insert(User user) {
		return userRepository.insert(user);	
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update (@PathVariable User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		
		return userRepository.save(newUser);
	}
	
	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		
	}

	public User fromDto(UserDto userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
}
