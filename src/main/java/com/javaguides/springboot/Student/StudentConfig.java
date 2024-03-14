package com.javaguides.springboot.Student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class StudentConfig {

	@Bean 
	
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args ->{
			Student  mary=new Student (1L, "Mary", "M@gmail.com", LocalDate.of(2002, 03, 11));
			
			Student alex = new Student (1L, "Alex", "alex@gmail.com", LocalDate.of(2001, 03, 11));
			
			Student john = new Student (1L, "John", "jo@gmail.com", LocalDate.of(1990, 03, 11));

			
			
			repository.saveAll(List.of(mary, alex));
		};
	}
}
