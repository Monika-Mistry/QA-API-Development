package com.bae.business.service;

public interface TraineeService {

	// C
	String addATrainee(String trainee);

	// R
	String getAllTrainees();

	// U
	String updateATrainee(int id, String trainee);

	// D
	String removeATrainee(int id);
}
