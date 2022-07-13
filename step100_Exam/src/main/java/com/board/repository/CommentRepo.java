package com.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.board.entity.CommentEntity;

@Repository
public interface CommentRepo extends JpaRepository<CommentEntity, Long>{
	public List<CommentEntity> findAllByBoardBoardNo(Long boardNo);
}
