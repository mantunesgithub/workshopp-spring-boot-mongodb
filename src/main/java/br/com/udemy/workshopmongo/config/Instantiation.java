package br.com.udemy.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.udemy.workshopmongo.domain.Post;
import br.com.udemy.workshopmongo.domain.User;
import br.com.udemy.workshopmongo.repository.PostRepository;
import br.com.udemy.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private	UserRepository userRepository;
	
	@Autowired
	private	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
//
		Post post1 = new Post(null, sdf.parse("21/01/2020"), "Partiu viajem", "Vou viajar para Sao Paulo, Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("23/01/2020"), "Bom dia", "Acordei feliz hoje!", maria);
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
