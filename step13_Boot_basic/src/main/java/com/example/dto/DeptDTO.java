package com.example.dto;

import com.example.entity.DeptEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeptDTO {
	private Integer deptno;
	private String dname;
	private String loc;



	public DeptEntity DeptDTOToEntity(DeptDTO deptDTO) {
		DeptEntity deptEntity = DeptEntity.builder().deptno(deptDTO.getDeptno()).dname(deptDTO.getDname())
				.loc(deptDTO.getLoc()).build();

		return deptEntity;
	}

}
