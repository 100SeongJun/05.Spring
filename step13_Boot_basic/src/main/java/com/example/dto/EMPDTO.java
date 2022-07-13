package com.example.dto;

import java.time.LocalDate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.entity.DeptEntity;
import com.example.entity.EmpEntity;

import lombok.Builder;
import lombok.Data;

@Data
//@DynamicUpdate
@Builder
public class EMPDTO {
	
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private LocalDate hiredate;
	private Double sal;
	private Double comm;
	@ManyToOne @JoinColumn(name = "deptno")
	private DeptEntity dept;
	
	public EmpEntity toEntity(EMPDTO empdto) {
		EmpEntity empEntity = EmpEntity.builder().empno(empdto.getEmpno()).
				ename(empdto.getEname()).job(empdto.getJob()).
				mgr(empdto.getMgr()).hiredate(empdto.getHiredate()).
				sal(empdto.getSal()).comm(empdto.getComm()).dept(empdto.getDept()).build();
		return empEntity;
	}
}

