package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dto.EMPDTO;

@Repository
public interface EmpRepository extends JpaRepository<EMPDTO, Integer> {
//	public List<EMPDTO> findAll();
	public EMPDTO findEmpByEmpno(Integer empno);
}
