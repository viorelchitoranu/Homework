package com.devmind.springapp.homeworkc20;

import com.devmind.springapp.homeworkc20.models.Profesor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class homeworkc20 implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(homeworkc20.class, args);
	}

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Profesor profesor = em.find(Profesor.class, 1);
		System.out.println(profesor.toString());
	}

}
