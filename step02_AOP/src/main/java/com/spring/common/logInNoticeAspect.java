package com.spring.common;

public class logInNoticeAspect {
	// 로그인 성공시 실행되는 공통 로직
	public void success(String user) {
		if (user != null) {
			System.out.println("로그인 성공");
		}
	}

	// 로그인 실패시 실행되는 공통 로직
	public void fail(Exception e) {
		System.out.println("로그인 실패");
	}

}
