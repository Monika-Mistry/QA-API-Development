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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllClassrooms() {
		return jsonUtil.getJSONForObject(classroomMap);
	}

	@Override
	public String updateClassroom(int id, String classroom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeAClassroom(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Integer, Classroom> getClassroomMap() {
		return classroomMap;
	}

}
