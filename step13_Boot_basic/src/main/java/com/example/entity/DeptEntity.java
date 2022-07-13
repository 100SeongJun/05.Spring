package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.dto.DeptDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@EntityListeners(AuditingEntityListener.class)
@Table(name = "DEPT")
public class DeptEntity {
	@Id @Column(name = "DEPTNO",nullable = false)
	private Integer deptno;
	private String dname;
	private String loc;

	public DeptDTO DeptEntityToDTO(DeptEntity deptEntity) {
		DeptDTO deptDTO = DeptDTO.builder().deptno(deptEntity.getDeptno())
				.dname(deptEntity.getDname()).loc(deptEntity.getLoc()).build();
		return deptDTO;
	}
}
