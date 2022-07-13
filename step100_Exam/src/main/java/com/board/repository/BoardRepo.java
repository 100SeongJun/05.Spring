package com.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.board.entity.BoardEntity;

@Repository
public interface BoardRepo extends JpaRepository<BoardEntity, Long>{
	
	
}
