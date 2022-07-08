package com.spring.service;

import java.util.List;

import com.spring.dto.DiaryDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Diary;

public interface DiaryService {
	public Diary insertDiary(DiaryDTO diary);
	public void insertDiaryBatch(List<DiaryDTO> diaryDTOList);
	public PageResultDTO<DiaryDTO, Diary> getList(PageRequestDTO pRDTO);
	public int getCountData();
}

