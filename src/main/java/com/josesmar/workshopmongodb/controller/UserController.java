package com.josesmar.workshopmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josesmar.workshopmongodb.entities.User;
import com.josesmar.workshopmongodb.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userService.findAll();
		
		if (list == null) {
			throw new IllegalAccessError("Error");
		}
		
		return ResponseEntity.ok().body(list);
	}
}
