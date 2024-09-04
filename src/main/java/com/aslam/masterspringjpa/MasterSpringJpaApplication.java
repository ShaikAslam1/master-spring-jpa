package com.aslam.masterspringjpa;

import com.aslam.masterspringjpa.domain.Author;
import com.aslam.masterspringjpa.repositories.AuthorRepository;
import com.aslam.masterspringjpa.repositories.VideoRepository;
import com.aslam.masterspringjpa.specification.AuthorSpecification;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

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
//			for (int i=0; i<50; i++) {
//				Faker faker = new Faker();
//				var author = Author.builder()
//						.firstname(faker.name().firstName())
//						.lastname(faker.name().lastName())
//						.age(faker.number().numberBetween(19, 50))
//						.email("contact" + i + "@epam.com")
//						.createdAt(LocalDateTime.now())
//						.build();
//				authorRepository.save(author);
//			}

//			var video = Video.builder()
//					.name("abc")
//					.length(10)
//					.build();
//			videoRepository.save(video);

			// find by named query
//			authorRepository.findByNamedQuery(20).forEach(System.out::println);
//			authorRepository.updateByNamedQuery(29);

			Specification<Author> spec = Specification
					.where(AuthorSpecification.hasAge(29))
					.and(AuthorSpecification.fistnameLike("Eri"));
			authorRepository.findAll(spec).forEach(System.out::println);
		};
	}

}
