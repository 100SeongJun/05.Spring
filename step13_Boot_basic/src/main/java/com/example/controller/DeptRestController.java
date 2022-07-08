package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Dept;
import com.example.service.DeptService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class DeptRestController {
	@Autowired
	private DeptService deptService;
	
	@GetMapping(value="/deptAll")
	public List<Dept> getDepts(){
		return deptService.getDeptAll();
	}
	
	@GetMapping(value="/dept/{deptno}")
	public Dept getDept(@PathVariable("deptno") Integer deptno) {
		System.out.println(deptno);
		return deptService.getDept(deptno);
	}
	
	@PostMapping(value="/dept/{deptno}")
	public Dept insertDept(@PathVariable("deptno") Integer deptno,
			@RequestParam("dname") String dname,
			@RequestParam("loc") String loc) {
		Dept dept = new Dept();
		dept.setDeptno(deptno);
		dept.setDname(dname);
		dept.setLoc(loc);
		return deptService.insertDept(dept); 
		
	}
	
	@PutMapping(value="/dept/{deptno}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Dept updateDept(@PathVariable("deptno")Integer deptno,@RequestBody HashMap<String, Object> map) {
		Dept dept = new Dept();
		dept.setDeptno(deptno);
		dept.setDname((String)map.get("dname"));
		dept.setLoc((String)map.get("loc"));
		System.out.println(dept);
		Dept resultDept = deptService.updateDept(dept);
		if(resultDept.equals(null)) {
			return null;
		}else {
			return resultDept;
		}
	}
	@DeleteMapping(value = "/dept/{deptno}")
	public Dept deleteDept(@PathVariable("deptno")Integer deptno) {
		return deptService.removeDept(deptno);
	}
	
}
