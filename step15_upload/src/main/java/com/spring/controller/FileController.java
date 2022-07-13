package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.FileDTO;
import com.spring.entity.FileEntity;
import com.spring.repository.FileRepository;
import com.spring.service.FileServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = { "http://localhost:3000" })
public class FileController {
	private final FileServiceImpl fileService;
	@Autowired
	FileRepository filerepo;

	@PostMapping("/file-save-test")
	public void testSaveFile(@RequestParam("file") MultipartFile file) {
		try {
			System.out.println("file-save");
			System.out.println(file);
			System.out.println(file.getContentType());
			System.out.println(file.getName());
			System.out.println(file.getOriginalFilename());

			// 파일 저장시 이름구분
			String originalName = file.getOriginalFilename();
			String fileName = UUID.randomUUID().toString() + "_" + originalName;
			System.out.println(fileName);

			// 파일 저장시 경로 설정
			String filePath = System.getProperty("user.dir") + "\\files";

			// 저장 폴더가 없을경우 파일을 만들어줘야함.
			if (new File(filePath).exists()) {
				new File(filePath).mkdir();
			}
			String finalFilePath = filePath + "\\" + fileName;
			file.transferTo(new File(finalFilePath));
			System.out.println(filePath);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}

	@PostMapping("file-save")
	public FileDTO fileSave(MultipartFile file) {
		try {
//			FileDTO filedto = new FileDTO();
			String originalName = file.getOriginalFilename();
			String fileName = UUID.randomUUID().toString() + "_" + originalName;

			String filePath = System.getProperty("user.dir") + "\\files";
			// 파일 저장시 경로 설정
			if (new File(filePath).exists()) {
				new File(filePath).mkdir();
			}
			String finalFilePath = filePath + "\\" + fileName;
			file.transferTo(new File(finalFilePath));

			FileDTO filedto = FileDTO.builder().originalFileName(originalName)
					.fileName(fileName).filePath(finalFilePath).build();

			return fileService.saveFile(filedto);

		} catch (Exception e) {
		}
		return null;
	}

	@GetMapping("file-list")
	public List<FileDTO> getFileList(MultipartFile file) {
		return fileService.getAll();
	}

//	@GetMapping("/file-download/{id}")
//	public void downloadFile(@PathVariable Long id,
//			HttpServletResponse response) throws IOException {
//		FileEntity file = filerepo.findById(id).get();
//		response.setHeader("Content-Disposition",
//				"attachment;filename=\"" + file.getFileName() + "\";");
//		FileInputStream fis = new FileInputStream(file.getFilePath());
//
//		try {
//			OutputStream os = response.getOutputStream();
//			int readCount = 0;
//			byte[] buffer = new byte[1024];
//			while ((readCount = fis.read(buffer)) != -1) {
//				os.write(buffer, 0, readCount);
//			}
//			os.flush();
//			os.close();
//			fis.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	@GetMapping("/file-download/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable Long id)
			throws IOException {
		FileEntity fileEntity = filerepo.findById(id).get();

		Path path = Paths.get(fileEntity.getFilePath());
		Resource resource = new InputStreamResource(
				Files.newInputStream((path)));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(ContentDisposition.builder("attachment")
				.filename(fileEntity.getOriginalFileName(),
						StandardCharsets.UTF_8)
				.build());
		headers.add(HttpHeaders.CONTENT_TYPE, "text/plain");

		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}

}
