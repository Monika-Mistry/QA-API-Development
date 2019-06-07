package com.bae.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.persistence.domain.Classroom;
import com.bae.util.Constants;
import com.bae.util.JSONUtil;

@Default
@Transactional(TxType.SUPPORTS)
public class ClassroomDataBaseRepository implements ClassroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonUtil;

	@Override
	public String addAClassroom(String classroom) {
		Classroom newClassroom = jsonUtil.getObjectForJSON(classroom, Classroom.class);
		manager.persist(newClassroom);
		return classroom;
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String getAllClassrooms() {
		Query query = manager.createQuery(Constants.GETALLCLASSROOMQUERY);
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return jsonUtil.getJSONForObject(classrooms);
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String updateClassroom(int id, String classroom) {
		Classroom classroomToUpdate = manager.find(Classroom.class, id);

		Classroom classroomInput = jsonUtil.getObjectForJSON(classroom, Classroom.class);

		classroomToUpdate.setTrainerFirstName(classroomInput.getTrainerFirstName());
		classroomToUpdate.setTrainerLastName(classroomInput.getTrainerLastName());

		manager.persist(classroomToUpdate);

		return jsonUtil.getJSONForObject(classroomToUpdate);
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String removeAClassroom(int id) {
		manager.remove(id);
		return "{\"message\":\"Classroom " + id + " removed\"}";
	}

}
