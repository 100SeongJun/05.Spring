package com.example.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EMPDTO;
import com.example.dto.PageRequestDTO;
import com.example.service.EMPServiceImpl;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class EmpRestController {
	@Autowired
	private EMPServiceImpl empService;

	@GetMapping(value = "/emp")
	public List<EMPDTO> findEmpAll() {
		return empService.findAll();
	}
	@GetMapping(value = "/emp/{empno}")
	public EMPDTO findEmp(@PathVariable("empno") Integer empno) {
		System.out.println(empno);
		return empService.getEmp(empno);
	}
	
	@PostMapping(value="/emp",consumes = MediaType.APPLICATION_JSON_VALUE)
	public EMPDTO insertEMP(@RequestBody EMPDTO emp) {
		
		return empService.insertEmp(emp);
	}
	
	@PutMapping(value="/emp/{empno}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public EMPDTO update(@PathVariable("empno") Integer empno,@RequestBody EMPDTO emp) {
		System.out.println(emp);
		emp.setEmpno(empno);
		return empService.updateEmp(emp);
	}
	@DeleteMapping(value="/emp/{empno}")
	public EMPDTO deleteEMP(@PathVariable("empno") Integer empno) {
		return empService.removeEmp(empno);
	}
	
//	@GetMapping(value = "/emp/loc/{loc}")
//	public List<EMPDTO> getEMPbyLoc(@PathVariable("loc") String loc) {
//		
//		return empService.findEMPbyLoc(loc);
//	}

	@GetMapping(value = "/emp/page")
	public List<EMPDTO> getEmp(PageRequestDTO pageRequestDTO){
		return empService.getEmpList(pageRequestDTO).getDtoList();
	}
}

