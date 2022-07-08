package com.spring.dto;

import com.spring.entity.FileEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO {
	private Long id;
	private String originalFileName;
	private String fileName;
	private String filePath;

	public FileEntity toEntity(FileDTO filedto) {
		FileEntity fileEntity = FileEntity.builder().id(filedto.id)
				.originalFileName(filedto.originalFileName)
				.fileName(filedto.fileName).filePath(filedto.filePath).build();
		return fileEntity;

	}
}
