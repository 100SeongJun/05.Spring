package com.spring.jdbc;

import java.util.ArrayList;
import java.util.List;
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
//		System.out.println(deptService.getDeptMap(20));
//		System.out.println(deptService.getDeptNameByDeptno(20));
//		System.out.println(deptService.getAllDeptsMap());
//		deptService.deleteDept("moon");
//		deptService.insertDept();
//		System.out.println(deptService.getAllDept());
//		System.out.println(deptService.getDeptByDeptno(20));
//		Dept depts = deptService.getDeptByDeptno(20);
//		session.setAttribute("depts", depts);
//		model.addAttribute("deptno", depts);
//		deptService.updateDept(50, "programming", "moon");
//		System.out.println(deptService.getAllDeptsMap());
		List<Dept> deptList = new ArrayList<Dept>();
		deptList.add(new Dept(60, "test1", "test1"));
		deptList.add(new Dept(70, "test2", "test2"));
		deptList.add(new Dept(80, "test3", "test3"));
		deptList.add(new Dept(90, "test4", "test4"));
		deptList.add(new Dept(100, "test5", "test5"));
//		deptService.insertDepts(deptList);
		System.out.println(deptList);
//		model.addAttribute("allDept", deptService.getAllDeptsMap());
//		update : where deptno 50 and dname= programming loc :moon
//		delete: where loc= "moon"
		return "home";

	}
}
