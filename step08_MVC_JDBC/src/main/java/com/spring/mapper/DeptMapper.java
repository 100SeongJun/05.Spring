package com.spring.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.dto.Dept;

public interface DeptMapper {
	public Dept getDeptByDeptno(int deptno);

	public String getDeptNameByDeptno(int deptno);

	public HashMap<String, Object> getDeptMap(int deptno);

	public List<Dept> getAllDept();

	public List<HashMap<String, Object>> getAllDeptsMap();

	public void insertDept(Dept dept);

	public void deleteDept(String dname);

	public void updateDept(Map data);

	public void insertDepts(List<Dept> deptList);
}
