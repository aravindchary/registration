package com.syncon.registation.dao;

import java.util.List;

import com.syncon.registation.model.Student;

public interface IStudentDAO {
	public void save(Student student);
	public List<Student> findAll();
	public Student findById(int id);
	public void update(Student student);
	public int delete(int id) ;
	Student findStudentByUserName(String userName);
}
