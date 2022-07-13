package com.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.board.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, String>{

}
