package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	
	public List<Student> getStudentList();
	
	public Student updateStudent(Student student);
	
	public Student deleteStudentById(Long id);
	
	public Student getStudentById(Long id);
}
