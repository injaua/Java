package com.injaua.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.injaua.entity.Student;
import com.injaua.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/")
	public String hello() {
		return "index.html";
	}
	
	//method to handle list students and return mode and view
	
	@GetMapping("/students")
	public String ListStudents(Model model) {
		List<Student> st = studentService.getAllStudents();
		model.addAttribute("students", st);
		return "students"; //view
	}
	
	@GetMapping("/student/new")
	public String createStudentForm(Model model){
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String EditStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model  model) {
		//get student from database
		Student student2 = studentService.getStudentById(id);
		student2.setId(id);
		student2.setFirstname(student.getFirstname());
		student2.setLastname(student.getLastname());
		student2.setEmail(student.getEmail());
		
		//Save
		studentService.updateStudent(student2);
		return "redirect:/students";
	}
	
	//delete request
	@GetMapping("/students/{id}")
	public String delete(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

}
