package entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class EMP {
	@Id
	private Integer empno;

	@Column(name = "ENAME", length = 10)
	private String ename;
	@Column(name = "JOB", length = 9)
	private String job;

	@Column(name = "SAL")
	private Integer mgr;

	@Column(name = "HIREDATE")
	private LocalDateTime hireDate;

	@Column(name = "SAL")
	private Double sal;

	@Column(name = "COMM")
	private Double comm;

	@Column(name = "DEPTNO", unique = true)
	private Integer deptNo;

}
