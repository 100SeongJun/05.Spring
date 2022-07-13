package com.board.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.dto.BoardDTO;
import com.board.dto.PageRequestDTO;
import com.board.dto.PageResultDTO;
import com.board.entity.BoardEntity;
import com.board.service.board.BoardServiceImpl;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
@RequestMapping("/board")
public class BoardRestController {

	@Autowired
	private BoardServiceImpl boardService;

	@GetMapping
	public PageResultDTO<BoardDTO, BoardEntity> getList(
			@ModelAttribute PageRequestDTO prDto) {
		return boardService.getList(prDto);
	}

	@GetMapping(value = "/{id}")
	public void getOneList(BoardDTO boardDto) throws Exception {
//		return boardService.getOne(boardDto);
		throw new Exception("접근실패");
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertBoard(@RequestBody BoardDTO boardDto) {
		boardService.insertBoard(boardDto);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateBoard(@PathVariable("id") Long boardNo,
			@RequestBody BoardDTO boardDto) {
		boardDto.setBoardNo(boardNo);
//		System.out.println(boardDto);
		boardService.updateBoard(boardDto);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteBoard(@PathVariable("id") Long boardNo) throws Exception {
		boardService.deleteBoard(boardNo);
		throw new Exception("예외 처리");
		}

//	@ExceptionHandler(FileNotFoundException.class)
//	public ResponseEntity<String> handlerException(Exception e) {
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//	}
}
