package com.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@Controller
public class StudentController {

	private StudentService sServ;

	public StudentController(StudentService sServ) {
		this.sServ = sServ;
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/students")
	public String getStudentsList(Model model) {
		model.addAttribute("students", sServ.getStudentList());
		return "students";
	}
	
	@GetMapping("/addstudent")
	public String createSTudentform(Model model) {
		Student student=new Student();
		model.addAttribute("student", student);
		return "create_Student";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student")  Student student) {
		sServ.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("updateStudent/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		Student st= sServ.getStudentById(id);
		model.addAttribute("student", st);
		return "edit_student";
	}
	
	@PostMapping("updateStudents/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
		Student st=sServ.getStudentById(id);
		st.setEmail(student.getEmail());
		st.setFirstName(student.getFirstName());
		st.setLastName(student.getLastName());
		sServ.saveStudent(st);
		return "redirect:/students";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Long id) {
		sServ.deleteStudentById(id);
		return "redirect:/students";
	}
	
}
