package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dto.DeptDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.entity.DeptEntity;
import com.example.repository.DeptRepository;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptRepository deptRepository;

	@Override
	public List<DeptDTO> getDeptAll() {
		
		List<DeptDTO> deptDTOList = new ArrayList<DeptDTO>();
		for(DeptEntity deptEntity :deptRepository.findAll()) {
			deptDTOList.add(deptEntity.DeptEntityToDTO(deptEntity));
		}
		return deptDTOList;
	}

	@Override
	public DeptDTO getDept(Integer deptno) {
		try {
			DeptEntity deptEntity = deptRepository.findDeptByDeptno(deptno);
			return deptEntity.DeptEntityToDTO(deptEntity);
			
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public DeptDTO insertDept(DeptDTO dept) {
		DeptEntity deptEntity = dept.DeptDTOToEntity(dept);
		System.out.println(deptEntity);
		deptRepository.save(deptEntity);
		return dept;
	}

	@Override
	public DeptDTO removeDept(Integer deptno) {
		DeptDTO findDept = getDept(deptno);
		
		if(findDept.equals(null)) {
			
			return null;
		}else {
			deptRepository.delete(findDept.DeptDTOToEntity(findDept));
			return findDept;
		}
		
	}

	//10 test tes2
	
	@Override
	public DeptDTO updateDept(DeptDTO dept) {
		DeptDTO findDept = getDept(dept.getDeptno());
		if(findDept.equals(null)) {
			return null;
		}else {
			findDept.setDname(dept.getDname());
			findDept.setLoc(dept.getLoc());
			deptRepository.save(findDept.DeptDTOToEntity(findDept));
			return findDept;
		}
	}

	@Override
	public PageResultDTO<DeptDTO, DeptEntity> getList(PageRequestDTO pRDTO) {
		Pageable pageable = pRDTO.getPageable(Sort.by("deptno").ascending());
		Page<DeptEntity> result = deptRepository.findAll(pageable);
		Function<DeptEntity, DeptDTO> function = (deptEntity-> deptEntity.DeptEntityToDTO(deptEntity));
		return new PageResultDTO<DeptDTO, DeptEntity>(result, function);	
	}
	
}
