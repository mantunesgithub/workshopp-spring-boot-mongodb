package br.com.udemy.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.udemy.workshopmongo.domain.User;
import br.com.udemy.workshopmongo.repository.UserRepository;
import br.com.udemy.workshopmongo.service.exception.ObjectNotfoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotfoundException("Objeto não encontrado")); 
	}
}
