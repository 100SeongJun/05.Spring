package com.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Dept;
import com.spring.mapper.DeptMapper;

@Service
public class DeptServiceImpl implements DeptService {
	/*
	 * @Override public List<HashMap<String, Object>> getAllDeptsMap() { return
	 * deptMapper.getAllDeptsMap(); }
	 */

	@Autowired
	DeptMapper deptMapper;

	@Override
	public List<Dept> getAllDepts() {
		return deptMapper.getAllDepts();
	}

	@Override
	public void insertDepts(List<Dept> deptList) {
	}

	@Override
	public void updateDept(Dept dept) {
		deptMapper.updateDept(dept);
	}

	@Override
	public void deleteDept(int deptno) {
		deptMapper.deleteDept(deptno);
	}

	@Override
	public Dept getDept(int deptno, String dname) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deptno", deptno);
		map.put("dname", dname);
		return deptMapper.getDept(map);
	}

	@Override
	public void insertDept(Dept dept) {
		deptMapper.insertDept(dept);
	}

}
