package com.spring.service;

import java.util.List;

import com.spring.dto.Dept;

public interface DeptService {
	/*
	 * // List<HashMap<String,Object>> List<HashMap<String, Object>>
	 * getAllDeptsMap();
	 */

	// List
	public List<Dept> getAllDepts();

	// 특정 값 insert
	public void insertDept(Dept dept);

	// 여러 값 insert
	public void insertDepts(List<Dept> deptList);

	// 특정 deptno update
	public void updateDept(Dept dept);

	// 특정 데이터 삭제
	public void deleteDept(int deptno);

	// 특정 데이터 검색
	public Dept getDept(int deptno, String dname);

}
