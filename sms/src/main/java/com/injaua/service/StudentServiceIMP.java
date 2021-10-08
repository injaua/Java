package com.injaua.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.injaua.entity.Student;
import com.injaua.repository.StudentRepository;

@Service
public class StudentServiceIMP implements StudentService {
	
	private StudentRepository studentRepository;
	

	public StudentServiceIMP(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}


	@Override
	public Student getStudentById(long id) {
		return studentRepository.findById(id).get(); //o findbyid retorna um optional
	}


	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}


	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}




}
