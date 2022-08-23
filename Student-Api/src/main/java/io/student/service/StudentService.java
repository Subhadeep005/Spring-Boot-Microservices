package io.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.student.model.Student;
import io.student.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	public List<Student> getAllStudents() {
		
		return studentRepo.findAll();
	}

	public Student getStudentById(int id) {
		
		return studentRepo.findById(id).get();
	}

	public Student getStudentsByName(String name) {
		return studentRepo.findByNameIgnoreCase(name);
	}

	
}
