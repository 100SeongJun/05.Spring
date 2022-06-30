package com.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.spring.dto.Dept;
import com.spring.service.DeptServiceImpl;

@org.springframework.web.bind.annotation.RestController
// @Controller + @Responsebody 결합된 형태 = @RestController
//@Controller
@JacksonStdImpl
public class RestController {

	@Autowired
	private DeptServiceImpl deptService;

	@GetMapping("/api/test")
	public String apiTest() {
		return "test2";
	}

	@GetMapping("/api/search")
	public Dept searchDept() {
		Dept depts = deptService.getDeptByDeptno(20);
		return depts;
	}

	@PostMapping(value = "/api/deptjson", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertDeptJSON(@RequestBody Dept dept) {
		deptService.insertDept(dept);
		System.out.println(deptService.getAllDeptsMap());
	}

	@PostMapping(value = "/api/deptform")
//	@PostMapping(value = "/api/depstform" )
	public void insertDeptForm(@ModelAttribute Dept dept) {
		System.out.println(dept);
	}
}
