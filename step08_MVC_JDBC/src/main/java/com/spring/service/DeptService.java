package com.spring.service;

import java.util.HashMap;
import java.util.List;

import com.spring.dto.Dept;

public interface DeptService {
	public Dept getDeptByDeptno(int deptno);

	public String getDeptNameByDeptno(int deptno);

	public HashMap<String, Object> getDeptMap(int deptno);

	public List<Dept> getAllDept();

	public List<HashMap<String, Object>> getAllDeptsMap();

	public void insertDept(Dept dept);

	public void deleteDept(String loc);

	public void updateDept(int deptno, String dname, String loc);

	public void insertDepts(List<Dept> deptList);

}
