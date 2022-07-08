package com.example.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

import com.example.entity.EmpEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@DynamicUpdate
@Builder
public class EMPDTO {
	
	@Id 
	@Column(name = "EMPNO")
	private Integer empno;
	@Column(name = "ENAME",length = 10)
	private String ename;
	
	@Column(name = "JOB",length = 9)
	private String job;
	
	@Column(name = "MGR")
	private Integer mgr;
	
	@Column(name = "HIREDATE")
	private LocalDate hiredate;
	
	@Column(name = "SAL")
	private Double sal;
	
	@Column(name = "COMM")
	private Double comm;
	@ManyToOne @JoinColumn(name = "deptno")
	private Dept dept;
	
	public EmpEntity toEntity(EMPDTO empdto) {
		EmpEntity empEntity = EmpEntity.builder().empno(empdto.getEmpno()).
				ename(empdto.getEname()).job(empdto.getJob()).
				mgr(empdto.getMgr()).hiredate(empdto.getHiredate()).
				sal(empdto.getSal()).comm(empdto.getComm()).dept(empdto.getDept()).build();
		return empEntity;
	}
}

