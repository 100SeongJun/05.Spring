package com.example.service;

import java.util.List;

import com.example.dto.Dept;

public interface DeptService {
	public List<Dept> getDeptAll();
	public Dept getDept(Integer deptno);
	public Dept insertDept(Dept dept);
	public Dept removeDept(Integer deptno);
	public Dept updateDept(Dept dept);
}
