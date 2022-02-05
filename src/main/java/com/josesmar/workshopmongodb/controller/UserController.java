package com.josesmar.workshopmongodb.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josesmar.workshopmongodb.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {


	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User josesmar = new User("1", "josesmar", "josesmar@gmail.com");
		User pamela = new User("2", "pamela", "pamela@gmail.com");
		
		List<User>list = new ArrayList<>();
		
		list.addAll(Arrays.asList(josesmar, pamela));		
		
		return ResponseEntity.ok().body(list);

	}
}
