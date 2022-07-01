package com.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.service.DeptServiceImpl;

@Controller
public class DeptController {

	@Autowired
	private DeptServiceImpl deptService;

//	@RequestMapping("/deptTest.do")
//	public String sessiondeptTest(Model model) {
////		System.out.println(deptService.getDeptByDeptno(10));
//		model.addAttribute("deptno",deptService.getDeptByDeptno(10));
//		return "forward:/home.jsp";
//	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String sessiondeptTest(Model model) {
//		System.out.println(deptService.getDeptNameByDeptno(10));
//		System.out.println(deptService.getDeptByDeptno(10));
//		System.out.println(deptService.getDeptMap(10));
////		System.out.println(deptService.getDeptMap(10).get("dname"));
//		System.out.println(deptService.getAllDepts());
//		System.out.println(deptService.getAllDeptsMap());
//		model.addAttribute("deptno",deptService.getDeptByDeptno(10));
//		model.addAttribute("dname",deptService.getDeptNameByDeptno(10));
//		model.addAttribute("map",deptService.getDeptMap(10));

//		deptService.insertDept(new Dept(50, "PROGRAMMING", "SEOUL"));

		// update : where deptno = 50 and dname="PROGRAMMING" ->loc : MOON
//		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("loc", "MOON");
//		data.put("deptno", 50);
//		data.put("dname", "PROGRAMMING");
//		
//		deptService.updateDeptByDeptnoAndDname(data);
//
//		//delete : where loc = "MOON" 
//		deptService.deleteDeptByLoc("MOON");
		return "home";
	}
}
