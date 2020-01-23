package br.com.udemy.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.udemy.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends  MongoRepository<Post, String>{
		
}
