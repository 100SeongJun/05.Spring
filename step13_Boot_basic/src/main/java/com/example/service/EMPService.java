package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.EMPDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.entity.EmpEntity;

@Service
public interface EMPService {
	public List<EMPDTO> findAll();
	public EMPDTO getEmp(Integer empno);
	public EMPDTO insertEmp(EMPDTO emp);
	public EMPDTO removeEmp(Integer empno);
	public EMPDTO updateEmp(EMPDTO emp);
	public List<EMPDTO> findEMPbyLoc(String loc);
	public PageResultDTO<EMPDTO, EmpEntity> getEmpList(PageRequestDTO pageReqDTO);

}
