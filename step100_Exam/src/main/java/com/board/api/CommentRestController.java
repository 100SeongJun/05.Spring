package com.board.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.dto.CommentDTO;
import com.board.service.comment.CommentServiceImpl;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = { "http://localhost:3000" })
public class CommentRestController {

	@Autowired
	CommentServiceImpl commentService;

	@GetMapping("/{id}")
	public List<CommentDTO> commentList(@PathVariable("id") Long boardNo) {

		return commentService.listComment(boardNo);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertComment(@RequestBody CommentDTO commentDto) {
		System.out.println(commentDto);
		commentService.insertComment(commentDto);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateComment(@PathVariable("id") Long commentNo ,@RequestBody CommentDTO commentDto) {
		commentDto.setCommentNo(commentNo);
		commentService.updateComment(commentDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteComment(@PathVariable("id") Long commentNo) {
		commentService.deleteComment(commentNo);
	}
}
