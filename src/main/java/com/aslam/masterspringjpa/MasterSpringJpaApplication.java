package com.aslam.masterspringjpa;

import com.aslam.masterspringjpa.domain.Author;
import com.aslam.masterspringjpa.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class MasterSpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterSpringJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository authorRepository) {
		return args -> {
			var author = Author.builder()
					.firstname("Aslam")
					.lastname("Shaik")
					.age(28)
					.email("aslam_shaik@epam.com")
					.createdAt(LocalDateTime.now())
					.build();
			authorRepository.save(author);
		};
	}

}
