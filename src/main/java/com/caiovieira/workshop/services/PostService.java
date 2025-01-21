package com.caiovieira.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiovieira.workshop.entities.Post;
import com.caiovieira.workshop.repositories.PostRepository;
import com.caiovieira.workshop.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	PostRepository postRepository;

	public Post findById(String id){
		Optional<Post> post = postRepository.findById(id);
		
		if (post.orElse(null) == null) {
			throw new ObjectNotFoundException("Post não encontrado");
		}
		
		return  post.get();
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.searchTitle(text);
	}
}
