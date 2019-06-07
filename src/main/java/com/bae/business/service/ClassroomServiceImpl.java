package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.ClassroomRepository;

public class ClassroomServiceImpl implements ClassroomService {

	@Inject
	private ClassroomRepository classroomRepository;

	@Override
	public String addAClassroom(String classroom) {
		return classroomRepository.addAClassroom(classroom);
	}

	@Override
	public String getAllClassrooms() {

		return classroomRepository.getAllClassrooms();
	}

	@Override
	public String updateClassroom(int id, String classroom) {

		return classroomRepository.updateClassroom(id, classroom);
	}

	@Override
	public String removeAClassroom(int id) {

		return classroomRepository.removeAClassroom(id);
	}

}
