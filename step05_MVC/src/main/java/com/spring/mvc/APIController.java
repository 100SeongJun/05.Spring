package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.domain.Customer;

@Controller
public class APIController {

	// id, age로 파라미터 전송하는 web query 데이터 처리

	@RequestMapping("getData1.do")
	public ModelAndView getOne(@RequestParam("id") String id, @RequestParam("age") int age) {
		ModelAndView model = new ModelAndView();
		System.out.println(id + "" + age);
		model.addObject("id", id);
		model.addObject("age", age);
		model.setViewName("view2");
		return model;
	}

	/*-
	 * Model API
	 * - model 클래스는 getParameter로 추출할 수 없는 데이터를
	 * request 객체에 저장하고자 할 때 사용 가능	
	 * */

	@RequestMapping("getData2.do")
	public String getTwo(Model model, Customer customer, String name) {
		System.out.println(customer.getAge() + " - " + customer.getName());
//		System.out.println("---------------");
//		System.out.println(customer.getName());
//		System.out.println(name);
//		System.out.println("---------------");

		// customer.setName("123");
		// name = "123";
		System.out.println(customer.getClass().hashCode());
		System.out.println(customer.getName());
		model.addAttribute("age", customer.getAge());
		model.addAttribute("name", customer.getName());
		model.addAttribute(customer);

		return "view2";
	}

	@RequestMapping("getData3.do")
	public String getThree(@ModelAttribute("customer") Customer customer) {
		return "view2";
		/*
		 * Customer customer = new Customer("busan",29);
		 * request.setAttribute("customer",Customer.name)
		 * request.setAttribute("customer",Customer.age)
		 */
	}

	// 예외처리 확인을 위한 test 메소드
	@GetMapping(value = "getData4.do")
	public void getFour() throws Exception {
		if (true) {
			throw new Exception("URL Exception");
		}
	}

	@ExceptionHandler
	public String exceptionHandling(Exception e) {
		return "redirect:errorView.jsp?msg=" + e.getMessage();
	}

}
