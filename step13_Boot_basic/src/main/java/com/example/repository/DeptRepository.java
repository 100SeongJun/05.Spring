package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.DeptEntity;

@Repository
public interface DeptRepository extends JpaRepository<DeptEntity, Integer> {
	public List<DeptEntity> findAll();

	public DeptEntity findDeptByDeptno(Integer deptno);
	
}
