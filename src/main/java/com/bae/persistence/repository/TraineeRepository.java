package com.bae.persistence.repository;

public interface TraineeRepository {

	// C
	String addATrainee(String trainee);

	// R
	String getAllTrainees();

	// U
	String updateTrainee(int id, String trainee);

	// D
	String removeATrainee(int id);

}
