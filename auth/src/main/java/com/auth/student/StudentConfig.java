package com.auth.student;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
  
  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository) {
    return args -> {
      Student mariam = new Student(1L, "Mariam", "mariam@gmail.com", LocalDate.of(2000, Month.FEBRUARY, 5));
      Student alex = new Student(2L, "Alex", "alex@gmail.com", LocalDate.of(2003, Month.JANUARY, 4));

	  repository.save(mariam);
	  repository.save(alex);
    };
  }
}
