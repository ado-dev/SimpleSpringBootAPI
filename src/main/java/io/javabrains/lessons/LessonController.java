package io.javabrains.lessons;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.course.Course;
import io.javabrains.topic.Topic;

/*
 * Controller class maps all the CRUD methods to URLs
 */

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	// GET all
	@RequestMapping(method = RequestMethod.GET, value="/topics/{topicsId}/courses/{id}/lessons")
	public List<Lesson> getAllLessons(@PathVariable String topicsId, @PathVariable String id){
		return lessonService.getAllLessons(id);
	}
	
	// GET one
	@RequestMapping(method = RequestMethod.GET, value="/topics/{topicsId}/courses/{courseId}/lessons/{id}")
	public Lesson getLesson(@PathVariable String id) {
		return lessonService.getLesson(id);
	}
	
	// SAVE / UDPATE
	@RequestMapping(method = RequestMethod.POST, value="/topics/{topicsId}/courses/{courseId}/lessons")
	public void saveLesson(@RequestBody Lesson lesson, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId, "", "", ""));
		lessonService.saveLesson(lesson);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void updateLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId, @PathVariable String id, Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		course.setId(courseId);
		lesson.setCourse(course);
		lessonService.saveLesson(lesson);
	}
	
	// DELETE
	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{topicsId}/courses/{courseId}/lessons/{id}")
	public void deleteLesson(@PathVariable String id) {
		lessonService.deleteLesson(id);
	}
}
