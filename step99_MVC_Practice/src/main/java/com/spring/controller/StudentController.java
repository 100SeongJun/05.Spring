package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.service.StudentServiceImpl;

@Controller
public class StudentController {

	@Autowired
	private StudentServiceImpl studentService;

	@GetMapping(value = "/")
	public String Student(Model model) {
		model.addAttribute("student", studentService.getAll());
		return "home";
	}
}
