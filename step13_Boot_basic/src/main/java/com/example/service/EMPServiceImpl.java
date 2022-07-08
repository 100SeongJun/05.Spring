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
import com.example.repository.EmpRepositorys;

@Service
public class EMPServiceImpl implements EMPService {
	@Autowired
	private EmpRepository empRepository;
	
//	@Autowired
	private EmpRepositorys empRepository2;

	@Override
	public List<EMPDTO> findAll() {
		return empRepository.findAll();
	}

	@Override
	public List<EMPDTO> findEMPbyLoc(String loc) {
		List<EMPDTO> empList = new ArrayList<EMPDTO>();
		System.out.println(loc);
		for (EMPDTO e : empRepository.findAll()) {
			System.out.println(e);
			if (e.getDept() != null && e.getDept().getLoc() != null) {
				if (e.getDept().getLoc().equals(loc)) {
					empList.add(e);
				}
			}
		}
		System.out.println(empList);
		return empList;
//		return null;
	}

	@Override
	public EMPDTO getEmp(Integer empno) {
		if (empRepository.findEmpByEmpno(empno) != null) {
			return empRepository.findEmpByEmpno(empno);
		}
		return null;
	}

	@Override
	public EMPDTO insertEmp(EMPDTO emp) {
		System.out.println(emp);
		if ((getEmp(emp.getEmpno()) == null)) {
			return empRepository.save(emp);
		}
		return null;
	}

	@Override
	public EMPDTO removeEmp(Integer empno) {
		EMPDTO emp = getEmp(empno);
		System.out.println(emp);
		if (!(emp == null)) {
			empRepository.delete(emp);
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
			empRepository.save(dbEmp);
		}
		return null;
	}
	
	//페이지
	@Override
	public PageResultDTO<EMPDTO, EmpEntity> getEmpList(PageRequestDTO pageReqDTO){
		Pageable pageable = pageReqDTO.getPageable(Sort.by("empno").ascending());
		Page<EmpEntity> result = empRepository2.findAll(pageable);
		Function<EmpEntity,EMPDTO> function = (empEntity-> empEntity.toDTO(empEntity));
		return new PageResultDTO<EMPDTO,EmpEntity>(result,function);
	}
}
