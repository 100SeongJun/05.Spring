package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.dto.DiaryDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Diary;
import com.spring.repository.DiaryRepo;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	DiaryRepo diaryRepo;

	@Transactional
	@Override
	public Diary insertDiary(DiaryDTO diary) {
		Diary diaryEntity = diary.toEntity(diary);
		return diaryRepo.save(diaryEntity);
	}

	@Transactional
	@Override
	public void insertDiaryBatch(List<DiaryDTO> diaryDTOList) {
		List<Diary> diaryEntityList = new ArrayList<Diary>();
		//version1
		for(DiaryDTO diary : diaryDTOList) {
			diaryEntityList.add(diary.toEntity(diary));
		}
//		System.out.println(diaryDTOList);
		
//		diaryDTOList.stream().forEach(diarydto -> diaryEntityList.add(diarydto.toEntity(diarydto)));
		// version2
//		diaryDTOList.forEach(dto->diaryEntityList.add(dto.toEntity(dto)));
		// version3
		List<Diary> diaryEntityList2 = diaryDTOList.stream()
				.map(dto-> dto.toEntity(dto))
				.collect(Collectors.toList());
		diaryRepo.saveAll(diaryEntityList2);
	}
	
	@Override
	public PageResultDTO<DiaryDTO, Diary> getList(PageRequestDTO pRDTO) {
		Pageable pageable = pRDTO.getPageable(Sort.by("no").descending());
		Page<Diary> result = diaryRepo.findAll(pageable);
		Function<Diary, DiaryDTO> function = (diaryEntity-> diaryEntity.toDTO(diaryEntity));
		return new PageResultDTO<DiaryDTO, Diary>(result, function);
	}

	@Override
	public int getCountData() {
		return (int)diaryRepo.count();
	}
	
}