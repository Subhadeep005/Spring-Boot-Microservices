package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;

	public List<Course> getAllCourses(String topicId) {
		// return (List<Course>) courseRepository.findAll();

		List<Course> courses = new ArrayList<Course>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}

	public Course getCourse(String id) {
		return courseRepository.findById(id).get();

	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {

		courseRepository.save(course);

	}

	public void deleteCourse(String id) {

		courseRepository.deleteById(id);
	}
}
