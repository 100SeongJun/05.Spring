package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Student;
import com.spring.mapper.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentMapper student;

	@Override
	public Student getAll() {
		System.out.println(student.getAllStudent());
		return null;
//		return student.getAllStudent();
	}

}
