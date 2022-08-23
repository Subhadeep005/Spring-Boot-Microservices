package io.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.student.model.Student;
import io.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/getallstudent")
	public List<Student> getAllStudent() {

		return service.getAllStudents();
	}

	@GetMapping("/getstudentbyid/{id}")
	public Student getStudentById(@PathVariable int id) {

		return service.getStudentById(id);
	}

	@GetMapping("/getstudentbyname/{name}")
	public Student getStudentByName(@PathVariable String name) {

		return service.getStudentsByName(name);
	}

}
