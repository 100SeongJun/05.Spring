package com.board.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = {"com.board.entity"})
@EnableJpaRepositories(basePackages = {"com.board.repository"} )
@ComponentScan(basePackages = {"com.board.api","com.board.service.**","com.board.exception"})
public class Step100ExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step100ExamApplication.class, args);
	}

}
