package br.com.udemy.workshopmongo.service;

import java.util.Date;
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
//  alternativa de pesquisa com @Query	
	public List<Post> findByTitle(String text) {
		return repo.searchByTitle(text);
	}
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
//		Essa data é gerada ate meia noite, então vamos acrescentar 1 dia na data para buscar os posts ate 24h daquele dia
//		porque ela é armazanada em milisegundos (instante) hhmmssmiliseg
		
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
