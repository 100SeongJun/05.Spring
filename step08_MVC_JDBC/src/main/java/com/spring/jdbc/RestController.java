package com.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.Dept;
import com.spring.service.DeptServiceImpl;

@org.springframework.web.bind.annotation.RestController
// @Controller + @Responsebody

public class RestController {

	@Autowired
	private DeptServiceImpl deptService;

	/*
	 * // @GetMapping(value= "/api/test") // public String apiTest() { // return
	 * "test2"; // }
	 * 
	 * // @PostMapping(value="/api/dept") // public void insertDept(Dept dept) {
	 * //// System.out.println(dept); // deptService.insertDept(dept); // } //
	 * // @GetMapping(value="/api/dept") // public String printDept(@RequestBody
	 * Dept dept) { //// System.out.println(dept); // return dept.toString(); // }
	 * 
	 * // @PostMapping(value="/api/deptjson", consumes =
	 * MediaType.APPLICATION_JSON_VALUE) // public void insertDeptJSON(@RequestBody
	 * Dept dept) { //// System.out.println(dept); // deptService.insertDept(dept);
	 * // } // // @PostMapping(value="/api/deptform", consumes =
	 * MediaType.APPLICATION_FORM_URLENCODED_VALUE) // public void
	 * insertDeptForm(@ModelAttribute Dept dept) { //// System.out.println(dept); //
	 * deptService.insertDept(dept); // }
	 * 
	 * 
	 * // @CrossOrigin(origins = { "http://localhost:3000" }) //
	 * http://localhost:8080/jdbc/api/deptData
	 * 
	 * // @GetMapping(value = "/api/dept/{deptno}/{dname}") // public List<Dept>
	 * deptData() { // return deptService.getAllDepts(); // }
	 */
	@PostMapping(value = "/api/deptjson", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertDeptForm3(@RequestBody Dept dept) {
//		System.out.println(dept);
		deptService.insertDept(dept);
	}

	@PostMapping(value = "api/deptjson", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void insertDeptForm4(Dept dept) {
//		System.out.println(dept);
		deptService.insertDept(dept);
	}

	@GetMapping(value = "/api/no-proxy")
	public String noProxy() {
		System.out.println("/no-proxy");
		return "no-proxy";
	}

	@GetMapping(value = "/api/proxy")
	public String Proxy() {
		System.out.println("/proxy");
		return "proxy";
	}

	@GetMapping(value = "/api/no-cors")
	public String noCors() {
		System.out.println("/no-cors");
		return "no-cors";
	}

	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4000" })
	@GetMapping(value = "/api/cors")
	public String cors() {
		System.out.println("/cors");
		return "cors";
	}

	// 모두 출력
	@GetMapping(value = "/api/dept", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public List<Dept> getAllDepts() {
		return deptService.getAllDepts();
	}

	// 특정 출력
	@GetMapping(value = "/api/dept/{deptno}/{dname}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Dept selectDept(@PathVariable int deptno, @PathVariable String dname) {
		return deptService.getDept(deptno, dname);
	}

	// 특정 삭제
	@DeleteMapping(value = "/api/dept", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public List<Dept> deleteDept(@RequestParam("deptno") int deptno) {
		System.out.println(deptno);
		deptService.deleteDept(deptno);
		return deptService.getAllDepts();
	}

	// 수정
	@PutMapping(value = "/api/dept", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Dept> updateDept(@RequestBody Dept dept) {
		System.out.println(dept);
		deptService.updateDept(dept);
		return deptService.getAllDepts();
	}

	// 생성
	@PostMapping(value = "/api/dept")
	public List<Dept> insertDept(@ModelAttribute Dept dept) {
		System.out.println(dept);
		deptService.insertDept(dept);
		return deptService.getAllDepts();
	}
}
