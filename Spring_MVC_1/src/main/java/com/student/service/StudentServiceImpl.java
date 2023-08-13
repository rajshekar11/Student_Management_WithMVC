package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepo sRepo;
	
	public StudentServiceImpl(StudentRepo sRepo) {
		this.sRepo = sRepo;
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return sRepo.save(student);
	}

	@Override
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		return sRepo.findAll();
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return sRepo.save(student);
	}

	@Override
	public Student deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		Optional<Student> st= sRepo.findById(id);
		Student stu=st.get();
		sRepo.delete(stu);
		return stu;
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return sRepo.getById(id);
	}

}
