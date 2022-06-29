package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.Customer;

@Controller
// @RequestMapping("session") 모든 요청값에 session을 붙이는 방법
// 
public class SessionController {

	@RequestMapping("cookietest.do")
	public String cookieTest(@CookieValue("id") String id) {
		System.out.println("id값 : " + id);
		return "redirect:/cookieTest.jsp";
	}

	@RequestMapping("index.do")
	public String index() {
		return "redirect:/index.jsp";
	}

	@RequestMapping("session.do")
	public String viewSession(HttpSession session) {
		System.out.println(session.getAttribute("Customer"));
		return "redirect:/sessionView.jsp";
	}

	@RequestMapping("session/remove.do")
	public String removeSession(HttpSession session) {
//	public String removeSession(SessionStatus sessionStatus) {
//		sessionStatus.setComplete();
//		return "redirect:/sessionView.jsp";
		session.removeAttribute("Customer");
		return "redirect:/sessionView.jsp";
	}

	/*
	 * @RequestMapping("session/removeAge.do") public String removeAge(HttpSession
	 * session) { Object obj = session.getAttribute("Customer"); Customer customer =
	 * (Customer) obj; return "redirect:/sessionView.jsp"; }
	 */

	@RequestMapping("session/get.do")
	public String getSession(HttpSession session) {
		Customer customer = new Customer(10, 20);
		session.setAttribute("Customer", customer);
		return "redirect:/sessionView.jsp";
	}

	@RequestMapping("session/loginForm.do")
	public String loginForm() {
		return "loginForm";
	}

	@RequestMapping("session/login.do")
	public String login(HttpSession session, @RequestParam("pwd") String pwd) {
		System.out.println(pwd);
		if ("1234".equals(pwd)) {
			session.setAttribute("pwd", pwd);
			return "redirect:/index.jsp";
		}
		return "loginForm";
	}

	@RequestMapping("session/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("pwd");
		System.out.println(session.getAttribute("pwd"));
		return "redirect:/";
	}
}
