package io.javabrains.lessons;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Service class contains all the methods for fetching and posting data
 */
@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;
	

	public List<Lesson> getAllLessons(String courseId) {
		List<Lesson> lessons = new ArrayList<>();
		lessonRepository.findByCourseId(courseId).forEach(lessons::add);
		return lessons;
	}

	public Lesson getLesson (String id) {
		return lessonRepository.findOne(id);
	}
	
	public void saveLesson (Lesson lesson) {
		lessonRepository.save(lesson);
	}
	
	public void deleteLesson (String id) {
		lessonRepository.delete(id);
	}
}
