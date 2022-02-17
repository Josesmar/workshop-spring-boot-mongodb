package com.josesmar.workshopmongodb.service;

import java.util.Date;
import java.util.List;
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
	
	public List<Post> findByTitle(String text){
		return postRepository.searchTitle(text);
//		return postRepository.findByTitleContainingIgnoreCase(text)(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return postRepository.fullSearch(text, minDate, maxDate);
		
	}
}
