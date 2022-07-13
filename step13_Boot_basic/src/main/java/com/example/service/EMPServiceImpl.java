package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dto.EMPDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.entity.EmpEntity;
import com.example.repository.EmpRepository;

@Service
public class EMPServiceImpl implements EMPService {
	@Autowired
	private EmpRepository empRepository;

	@Override
	public List<EMPDTO> findAll() {
		List<EMPDTO> empDTO = new ArrayList<EMPDTO>();
		for(EmpEntity empEntity : empRepository.findAll()) {
			empDTO.add(empEntity.toDTO(empEntity));
		}
		return empDTO; 
	}

	@Override
	public List<EMPDTO> findEMPbyLoc(String loc) {
		List<EMPDTO> empDTOList = new ArrayList<EMPDTO>();
		System.out.println(loc);
		for (EmpEntity empEntity : empRepository.findAll()) {
			if (empEntity.getDept() != null && empEntity.getDept().getLoc() != null) {
				if (empEntity.getDept().getLoc().equals(loc)) {
					empDTOList.add(empEntity.toDTO(empEntity));
				}
			}
		}
		return empDTOList;
	}

	@Override
	public EMPDTO getEmp(Integer empno) {
		if (empRepository.findEmpByEmpno(empno) != null) {
			EmpEntity empEntity = empRepository.findEmpByEmpno(empno);
			EMPDTO empdto = empEntity.toDTO(empEntity);
			return empdto;
		}
		return null;
	}

	@Override
	public EMPDTO insertEmp(EMPDTO emp) {
		System.out.println(emp);
		if ((getEmp(emp.getEmpno()) == null)) {
			EmpEntity empEntity = empRepository.save(emp.toEntity(emp));
			EMPDTO empDTO = empEntity.toDTO(empEntity); 
			return empDTO;
		}
		return null;
	}

	@Override
	public EMPDTO removeEmp(Integer empno) {
		EMPDTO emp = getEmp(empno);
		System.out.println(emp);
		
		if (emp != null) {
			empRepository.delete(emp.toEntity(emp));
			return emp;
		}
		return null;
	}

	@Override
	public EMPDTO updateEmp(EMPDTO emp) {
		EMPDTO dbEmp = getEmp(emp.getEmpno());
		if (dbEmp != null) {

			dbEmp.setEname(emp.getEname() == null ? dbEmp.getEname() : emp.getEname());
			dbEmp.setHiredate(emp.getHiredate() == null ? dbEmp.getHiredate(): emp.getHiredate());
			dbEmp.setJob(emp.getJob() == null ? dbEmp.getJob() : emp.getJob());
			dbEmp.setComm(emp.getComm() == null ? dbEmp.getComm() : emp.getComm());
			dbEmp.setMgr(emp.getMgr() == null ? dbEmp.getMgr() : emp.getMgr());
			dbEmp.setSal(emp.getSal() == null ? dbEmp.getSal() : emp.getSal());
			dbEmp.setDept(emp.getDept() == null ? dbEmp.getDept() : emp.getDept());
			empRepository.save(dbEmp.toEntity(dbEmp));
		}
		return null;
	}
	
	//페이지
	@Override
	public PageResultDTO<EMPDTO, EmpEntity> getEmpList(PageRequestDTO pageReqDTO){
		Pageable pageable = pageReqDTO.getPageable(Sort.by("empno").ascending());
		Page<EmpEntity> result = empRepository.findAll(pageable);
		Function<EmpEntity,EMPDTO> function = (empEntity-> empEntity.toDTO(empEntity));
		return new PageResultDTO<EMPDTO,EmpEntity>(result,function);
	}
}
