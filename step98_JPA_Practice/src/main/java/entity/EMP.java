package entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class EMP {
	
	@Id @Column(name = "EMPNO")
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
	
	@Column(name = "DEPTNO")
	private Integer deptno;
	
	
}

