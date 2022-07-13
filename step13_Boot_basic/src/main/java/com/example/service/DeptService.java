package com.example.service;

import java.util.List;

import com.example.dto.DeptDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.entity.DeptEntity;

public interface DeptService {
	public List<DeptDTO> getDeptAll();
	public DeptDTO getDept(Integer deptno);
	public DeptDTO insertDept(DeptDTO dept);
	public DeptDTO removeDept(Integer deptno);
	public DeptDTO updateDept(DeptDTO dept);
	public PageResultDTO<DeptDTO, DeptEntity> getList(PageRequestDTO pRDTO);
}
