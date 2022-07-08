package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.dto.FileDTO;
import com.spring.entity.FileEntity;
import com.spring.repository.FileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{

	private final FileRepository filerepo;
	
	@Override
	public FileDTO saveFile(FileDTO fileDTO) {
		FileEntity fileEntity = fileDTO.toEntity(fileDTO);
		filerepo.save(fileEntity);
		return fileDTO;
	}

	@Override
	public List<FileDTO> getAll() {
		List<FileEntity> fileEntityList = filerepo.findAll();
		List<FileDTO> fileDTOList =new ArrayList<FileDTO>();
		for(FileEntity file: fileEntityList) {
			fileDTOList.add(file.toDTO(file));
		}
		return fileDTOList;
	}

}
