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

	@Autowired
	DeptMapper deptMapper;

	@Override
	public Dept getDeptByDeptno(int deptno) {

		return deptMapper.getDeptByDeptno(deptno);
	}

	@Override
	public String getDeptNameByDeptno(int deptno) {

		return deptMapper.getDeptNameByDeptno(deptno);
	}

	@Override
	public HashMap<String, Object> getDeptMap(int deptno) {
		return deptMapper.getDeptMap(deptno);
	}

	@Override
	public List<Dept> getAllDept() {
		return deptMapper.getAllDept();
	}

	public List<HashMap<String, Object>> getAllDeptsMap() {
		return deptMapper.getAllDeptsMap();
	};

	public void insertDept(Dept dept) {
		deptMapper.insertDept(dept);
	};

	public void deleteDept(String loc) {
		deptMapper.deleteDept(loc);
	}

	public void updateDept(int deptno, String dname, String loc) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("deptno", deptno);
		data.put("dname", dname);
		data.put("loc", loc);
		deptMapper.updateDept(data);

	}

	public void insertDepts(List<Dept> deptList) {
		deptMapper.insertDepts(deptList);
	};

}
