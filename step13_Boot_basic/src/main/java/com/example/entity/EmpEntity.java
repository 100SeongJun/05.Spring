package com.example.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.dto.Dept;
import com.example.dto.EMPDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
public class EmpEntity implements Persistable<Integer>{
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
	@CreatedDate
	private LocalDate hiredate;
	
	@Column(name = "SAL")
	private Double sal;
	
	@Column(name = "COMM")
	private Double comm;
	@ManyToOne @JoinColumn(name = "deptno")
	private Dept dept;
	
	@Override
	public Integer getId() {
		return empno;
	}
	@Override
	public boolean isNew() {
		return empno == null;
	}
	
	public EMPDTO toDTO(EmpEntity empEntity) {
		EMPDTO empDto = EMPDTO.builder().empno(empEntity.getEmpno()).
				ename(empEntity.getEname()).job(empEntity.getJob()).
				mgr(empEntity.getMgr()).hiredate(empEntity.getHiredate()).
				sal(empEntity.getSal()).comm(empEntity.getComm()).dept(empEntity.getDept()).build();
		return empDto;
	}
	
	
}
