package com.example.dto;

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

//	public DeptDTO(Integer deptno) {
//		if(deptno != null) {
//			this.deptno = deptno;
//		}
//	}

	public Dept dtoToEntity(DeptDTO deptDTO) {
		Dept deptEntity = Dept.builder().dname(deptDTO.getDname())
				.loc(deptDTO.getLoc()).build();

		return deptEntity;
	}

}
