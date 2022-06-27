package com.spring.di.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "step04.model.domain")
public class Step04Config {

//	@Bean
//	public Car car() {
//		Car car = new Car();
//		return car;
//	}
//
//	@Bean
//	// 세터 주입
//	public People people(Car car) {
//		People people = new People();
//		people.setMyCar(car);
//		return people;
//	}

}
