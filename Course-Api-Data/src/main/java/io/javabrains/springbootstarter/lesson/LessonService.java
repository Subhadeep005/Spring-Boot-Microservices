package io.javabrains.springbootstarter.lesson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

	@Autowired
	LessonRepository courseRepository;

	public List<Lesson> getAllCourses(String topicId) {
		// return (List<Course>) courseRepository.findAll();

		List<Lesson> courses = new ArrayList<Lesson>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}

	public Lesson getCourse(String id) {
		return courseRepository.findById(id).get();

	}

	public void addCourse(Lesson course) {
		courseRepository.save(course);
	}

	public void updateCourse(Lesson course) {

		courseRepository.save(course);

	}

	public void deleteCourse(String id) {

		courseRepository.deleteById(id);
	}
}
