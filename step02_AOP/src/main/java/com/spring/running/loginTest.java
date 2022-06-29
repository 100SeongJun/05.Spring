package com.spring.running;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.User;

public class loginTest {

	public static void main(String[] args) {
		// login.xml을
		ApplicationContext context = new ClassPathXmlApplicationContext("login.xml");
		User user = context.getBean("user", User.class);
		try {
			user.login("admin");
			user.login("null");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
