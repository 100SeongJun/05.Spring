package com.spring.aop;

public class User {
	public String login(String user) throws Exception {
		String name = null;

		if ("admin".equals(user) || "admin".equals(user)) {
			name = user;
		} else {
			throw new Exception("Id확인 요망");
		}

		return name;
	}
}
