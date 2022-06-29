package com.spring.running;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.Car;

public class TestStart {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		Car car = context.getBean("car", Car.class);
		((ConfigurableApplicationContext) context).close();
		car.buy();
		car.buyMoney(2000);
		car.buyReturn();
		try {
			car.sellCar(300);
		} catch (Exception e) {
		}
	}
}
