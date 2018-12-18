package com.syncon.registation.service;

import java.util.List;

import com.syncon.registation.model.Student;

public interface IStudentService {

	void save(Student student) throws Exception;

	void update(Student student);

	List<Student> findAll();

	Student findById(int id);

	int delete(int id) throws Exception;
}
