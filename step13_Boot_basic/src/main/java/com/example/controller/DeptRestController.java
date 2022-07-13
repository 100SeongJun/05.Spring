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

import com.example.dto.DeptDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.entity.DeptEntity;
import com.example.service.DeptServiceImpl;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class DeptRestController {
	@Autowired
	private DeptServiceImpl deptService;
	
	@GetMapping(value="/deptAll")
	public List<DeptDTO> getDepts(){
		return deptService.getDeptAll();
	}
	
	//수정 : 페이지의 정보를 다 가지고 있음. front에서 필요한 정보에 관해 사용하면 됨
	@GetMapping(value = "/deptPage")
	public PageResultDTO<DeptDTO, DeptEntity> getPageDept(PageRequestDTO pageRequestDTO){
		System.out.println(pageRequestDTO);
		return deptService.getList(pageRequestDTO);
	}
	
	@GetMapping(value="/dept/{deptno}")
	public DeptDTO getDept(@PathVariable("deptno") Integer deptno) {
		return deptService.getDept(deptno);
	}
	
	@PostMapping(value="/dept/{deptno}")
	public DeptDTO insertDept(@PathVariable("deptno") Integer deptno,
			@RequestParam("dname") String dname,
			@RequestParam("loc") String loc) {
		DeptDTO dept = new DeptDTO();
		dept.setDeptno(deptno);
		dept.setDname  (dname);
		dept.setLoc(loc);
		System.out.println(dept);
		return deptService.insertDept(dept); 
		
	}
	
	@PutMapping(value="/dept/{deptno}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public DeptDTO updateDept(@PathVariable("deptno")Integer deptno,@RequestBody HashMap<String, Object> map) {
		DeptDTO dept = new DeptDTO();
		dept.setDeptno(deptno);
		dept.setDname((String)map.get("dname"));
		dept.setLoc((String)map.get("loc"));
		DeptDTO resultDept = deptService.updateDept(dept);
		if(resultDept.equals(null)) {
			return null;
		}else {
			return resultDept;
		}
	}
	@DeleteMapping(value = "/dept/{deptno}")
	public DeptDTO deleteDept(@PathVariable("deptno")Integer deptno) {
		return deptService.removeDept(deptno);
	}
	
}
