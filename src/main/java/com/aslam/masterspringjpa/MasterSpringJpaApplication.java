package com.aslam.masterspringjpa;

import com.aslam.masterspringjpa.domain.Author;
import com.aslam.masterspringjpa.domain.Video;
import com.aslam.masterspringjpa.repositories.AuthorRepository;
import com.aslam.masterspringjpa.repositories.VideoRepository;
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
	public CommandLineRunner commandLineRunner(
			AuthorRepository authorRepository,
			VideoRepository videoRepository) {
		return args -> {
			var author = Author.builder()
					.firstname("Aslam")
					.lastname("Shaik")
					.age(28)
					.email("aslam_shaik@epam.com")
					.createdAt(LocalDateTime.now())
					.build();
			authorRepository.save(author);

			var video = Video.builder()
					.name("abc")
					.length(10)
					.build();
			videoRepository.save(video);
		};
	}

}
