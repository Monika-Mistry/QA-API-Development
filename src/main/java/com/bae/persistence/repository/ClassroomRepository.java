package com.bae.persistence.repository;

public interface ClassroomRepository {

	// C
	String addAClassroom(String classroom);

	// R
	String getAllClassrooms();

	// String getAClassroom(int id);

	// U
	String updateClassroom(int id, String classroom);

	// D
	String removeAClassroom(int id);

}
