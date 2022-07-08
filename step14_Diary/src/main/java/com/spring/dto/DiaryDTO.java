package com.spring.dto;

import java.time.LocalDateTime;

import com.spring.entity.Diary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiaryDTO {
	private Long no;

	private String title;

	private String content;

	private LocalDateTime writtenTime;

	public Diary toEntity(DiaryDTO diary) {
		Diary diaryEntity = Diary.builder().no(diary.getNo())
				.title(diary.getTitle()).content(diary.getContent()).build();

		return diaryEntity;
	}
}
