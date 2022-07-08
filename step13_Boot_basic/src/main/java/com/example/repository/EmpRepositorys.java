package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.EmpEntity;
@Repository
public interface EmpRepositorys extends JpaRepository<EmpEntity, Integer>{

}
