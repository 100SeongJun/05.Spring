package com.example.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
//@Builder
@Data	//entity는 set을 사용하면 안된다. DB에 직접적으로 영향을 미치기 때문에
@Entity
@Builder
public class Dept {
//	public Dept() {
//		// TODO Auto-generated constructor stub
//	}
	@Id	@Column(name = "deptno")
	private Integer deptno;
	@Column(name = "DNAME")
	private String dname;
	@Column(name = "LOC")
	private String loc;
	
}
