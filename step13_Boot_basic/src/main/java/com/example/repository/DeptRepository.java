package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dto.Dept;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer> {
	public List<Dept> findAll();

	public Dept findDeptByDeptno(Integer deptno);
	
}
