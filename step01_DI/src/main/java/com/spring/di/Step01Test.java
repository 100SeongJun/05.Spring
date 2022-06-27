package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step01.model.domain.Car;
import step01.model.domain.People;

public class Step01Test {
	public static void main(String[] args) {
		// 생성자 주입(Constructor Injection)
		// 이미 생성자는 14Line에서 모두 생성
		System.out.println("생성자 생성 (bean 호출)");
		ApplicationContext context = new ClassPathXmlApplicationContext("step01.xml");
		System.out.println("----------------------");
		Car c1 = context.getBean("c1", Car.class);
		System.out.println(c1);
		People p1 = context.getBean("p1", People.class);
		System.out.println(p1);
		/*-
		 * People p1 = new People();
		 * p1.setName("Spring");
		 * p1.setAge(29);
		 * p1.setMyCar(c1);
		 * 
		 * */
		People p2 = context.getBean("p2", People.class);
		System.out.println(p2);
		// 과연 객채 생성 순서는 ?

		System.out.println(p1.getMyCar() == p2.getMyCar());
		((ConfigurableApplicationContext) context).close();
	}
}