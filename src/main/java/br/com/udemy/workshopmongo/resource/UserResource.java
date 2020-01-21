package br.com.udemy.workshopmongo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.udemy.workshopmongo.domain.User;
import br.com.udemy.workshopmongo.dto.UserDTO;
import br.com.udemy.workshopmongo.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService  service;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){

		List<User> list = service.findAll();
		
//		Converte cada elemento de list para ListDTO 
//		list. ==>Lista original    stream()==>Tranforma lista original para uma coleção compativel com as expressoes lambda Java 8
//		map(x -> new UserDTO (x))  		   ==>Pega cada elemento X da lista original e vai retornar um UserDTO parassando o X como argumento
//		.collect(Collectors.toList());	   ==>Volta o stream para lista 	
		
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO (x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
