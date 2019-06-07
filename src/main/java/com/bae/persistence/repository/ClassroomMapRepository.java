package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.bae.persistence.domain.Classroom;
import com.bae.util.JSONUtil;

public class ClassroomMapRepository implements ClassroomRepository {

	private Map<Integer, Classroom> classroomMap = new HashMap<Integer, Classroom>();

	private JSONUtil jsonUtil = new JSONUtil();

	@Override
	public String addAClassroom(String classroom) {
		Classroom newClassroom = jsonUtil.getObjectForJSON(classroom, Classroom.class);
		classroomMap.put(newClassroom.getClassroomId(), newClassroom);
		return classroom;
	}

	@Override
	public String getAllClassrooms() {
		return jsonUtil.getJSONForObject(classroomMap);
	}

	@Override
	public String updateClassroom(int id, String classroom) {
		Classroom classroomToUpdate = classroomMap.get(id);

		Classroom classroomInput = jsonUtil.getObjectForJSON(classroom, Classroom.class);

		classroomToUpdate.setTrainerFirstName(classroomInput.getTrainerFirstName());
		classroomToUpdate.setTrainerLastName(classroomInput.getTrainerLastName());

		classroomMap.replace(1, classroomToUpdate);

		return jsonUtil.getJSONForObject(classroomMap.get(1));
	}

	@Override
	public String removeAClassroom(int id) {
		classroomMap.remove(id);
		return "{\"message\": \"Classroom " + id + " removed\"}";
	}

	public Map<Integer, Classroom> getClassroomMap() {
		return classroomMap;
	}

}
