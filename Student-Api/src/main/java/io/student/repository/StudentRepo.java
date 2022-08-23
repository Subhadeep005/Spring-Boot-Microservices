package io.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.student.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	Student findByNameIgnoreCase(String name);

}
