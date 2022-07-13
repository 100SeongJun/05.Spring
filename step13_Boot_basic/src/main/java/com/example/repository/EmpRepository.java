package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.EmpEntity;

@Repository
public interface EmpRepository extends JpaRepository<EmpEntity, Integer> {
	public List<EmpEntity> findAll();
	public EmpEntity findEmpByEmpno(Integer empno);
}
