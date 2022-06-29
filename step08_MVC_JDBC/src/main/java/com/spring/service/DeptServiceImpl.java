package com.spring.service;

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

}
