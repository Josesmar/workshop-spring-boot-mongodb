package com.josesmar.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.josesmar.workshopmongodb.dto.AuthorDto;
import com.josesmar.workshopmongodb.dto.ComentDto;
import com.josesmar.workshopmongodb.entities.Post;
import com.josesmar.workshopmongodb.entities.User;
import com.josesmar.workshopmongodb.repository.PostRepository;
import com.josesmar.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepositoy;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepositoy.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));		
		
		Post post1 = new Post(null, sdf.parse("21/03/2021"), "Partiu viagem", "Vou viajar para São Paulo - Abraços", new AuthorDto(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2021"), "Bom dia", "Vou trabalhar hoje", new AuthorDto(maria));		
		
		ComentDto comentDto1 = new ComentDto("Boa viagem mano!", sdf.parse("25/01/2021"), new AuthorDto(alex));
		ComentDto comentDto2 = new ComentDto("Aproveite!", sdf.parse("01/01/2021"), new AuthorDto(bob));
		ComentDto comentDto3 = new ComentDto("Tenha um ótimo dia!", sdf.parse("02/01/2021"), new AuthorDto(alex));
		
		
		post1.getComents().addAll(Arrays.asList(comentDto1, comentDto2));
		post2.getComents().addAll(Arrays.asList(comentDto3));
		
		postRepositoy.saveAll(Arrays.asList(post1, post2));
		
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));	
		userRepository.save(maria);
	}

}
