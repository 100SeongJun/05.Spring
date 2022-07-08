package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Dept;
import com.example.repository.DeptRepository;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptRepository deptRepository;

	@Override
	public List<Dept> getDeptAll() {
		return deptRepository.findAll();
	}

	@Override
	public Dept getDept(Integer deptno) {
		return deptRepository.findDeptByDeptno(deptno);
	}

	@Override
	public Dept insertDept(Dept dept) {
		return deptRepository.save(dept);
	}

	@Override
	public Dept removeDept(Integer deptno) {
		Dept findDept = deptRepository.findDeptByDeptno(deptno);
		if(findDept.equals(null)) {
			
			return null;
		}else {
			deptRepository.delete(findDept);
			return findDept;
		}
		
	}

	//10 test tes2
	
	@Override
	public Dept updateDept(Dept dept) {
		Dept findDept = deptRepository.findDeptByDeptno(dept.getDeptno());
		if(findDept.equals(null)) {
			return null;
		}else {
			findDept.setDname(dept.getDname());
			findDept.setLoc(dept.getLoc());
			deptRepository.save(findDept);
			return findDept;
		}
	}
	
}
