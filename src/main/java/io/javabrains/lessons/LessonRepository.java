package io.javabrains.lessons;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/*
 * Repository interface inherits all the CRUD methods from
 * CrudRepository which, when injected into a service class
 * allows using standard CRUD methods. It also allows creating
 * methods specific to our own needs (ex. findByProp, findByObjProp, ...)
*/

public interface LessonRepository extends CrudRepository<Lesson, String> {
	
	public List<Lesson> findByCourseId(String id);
	
}
