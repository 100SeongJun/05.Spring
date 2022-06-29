package com.spring.jdbc;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.Dept;
import com.spring.service.DeptServiceImpl;

@Controller
public class DeptController {
	@Autowired
	private DeptServiceImpl deptService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		System.out.println(deptService.getDeptByDeptno(20));
		Dept depts = deptService.getDeptByDeptno(20);
		session.setAttribute("depts", depts);
		model.addAttribute("deptno", depts);
		return "home";

	}
}
