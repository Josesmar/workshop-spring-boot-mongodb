package com.josesmar.workshopmongodb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josesmar.workshopmongodb.entities.Post;
import com.josesmar.workshopmongodb.repository.PostRepository;
import com.josesmar.workshopmongodb.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	

	public Post findById(String id) {	
		Optional<Post> user = postRepository.findById(id);	
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));		
	}
}
