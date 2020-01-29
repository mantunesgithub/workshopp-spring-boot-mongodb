package br.com.udemy.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.udemy.workshopmongo.domain.Post;
import br.com.udemy.workshopmongo.repository.PostRepository;
import br.com.udemy.workshopmongo.service.exception.ObjectNotfoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotfoundException("Objeto não encontrado")); 
	}
//	public List<Post> findByTitle(String text) {
//		return repo.findByTitleContainingIgnoreCase(text);
//	}
	public List<Post> findByTitle(String text) {
		return repo.searchByTitle(text);
	}
}
