package com.caiovieira.workshop.config;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.caiovieira.workshop.dto.AuthorDTO;
import com.caiovieira.workshop.dto.CommentDTO;
import com.caiovieira.workshop.entities.Post;
import com.caiovieira.workshop.entities.User;
import com.caiovieira.workshop.repositories.PostRepository;
import com.caiovieira.workshop.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		List<User> userList = List.of(maria, alex, bob);
		userRepository.saveAll(userList);
		
		
		Post post1 = new Post(null, LocalDateTime.now(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, LocalDateTime.now(), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem!", LocalDateTime.now(), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", LocalDateTime.now(), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha uma ótima viagem!", LocalDateTime.now(), new AuthorDTO(alex));
		
		List<Post> postList = List.of(post1, post2);
		postRepository.saveAll(postList);
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);
		
		postRepository.save(post1);
		postRepository.save(post2);
	}

}
