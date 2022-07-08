package com.spring.service;

import java.util.List;

import com.spring.dto.FileDTO;

public interface FileService {
	public FileDTO saveFile(FileDTO fileDTO);
	public List<FileDTO> getAll();
}
