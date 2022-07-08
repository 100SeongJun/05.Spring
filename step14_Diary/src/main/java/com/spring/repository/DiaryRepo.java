package com.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Diary;

@Repository
public interface DiaryRepo extends JpaRepository<Diary, Long>{
	
	public Page<Diary> findByNoBetween(long from, long to, Pageable pageable3);

}
